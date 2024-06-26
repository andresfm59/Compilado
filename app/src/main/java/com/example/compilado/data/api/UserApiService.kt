package com.example.compilado.data.api

import com.example.compilado.data.api.network.response.UserResponse
import com.example.compilado.domain.model.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @POST("users")
    suspend fun createUser(@Body userModel: UserModel): UserResponse
}