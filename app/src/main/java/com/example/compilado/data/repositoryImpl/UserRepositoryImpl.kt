package com.example.compilado.data.repositoryImpl

import android.util.Log
import com.example.compilado.data.api.UserApiService
import com.example.compilado.domain.model.UserModel
import com.example.compilado.data.api.network.response.UserResponse
import com.example.compilado.domain.repository.UserRepository
import retrofit2.Call
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: UserApiService) : UserRepository {

    override suspend fun getUsers(): List<UserModel>? {
        runCatching { apiService.getUsers() }
            .onSuccess {  userResponseList -> return userResponseList.map { it.toDomain() } }
            .onFailure { Log.i("Compilado", "Ha ocurrido un error ${it.message}") }
        return null
    }

    override suspend fun createUser(userModel: UserModel): UserModel? {
        runCatching { apiService.createUser(userModel) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Compilado", "Ha ocurrido un error ${it.message}") }
        return null
    }

}