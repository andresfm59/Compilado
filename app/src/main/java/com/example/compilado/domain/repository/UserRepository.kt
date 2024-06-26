package com.example.compilado.domain.repository

import com.example.compilado.domain.model.UserModel
import retrofit2.Call

interface UserRepository {
    suspend fun getUsers(): List<UserModel>?
    suspend fun createUser(userModel: UserModel): UserModel?
}