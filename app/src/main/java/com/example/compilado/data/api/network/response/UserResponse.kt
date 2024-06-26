package com.example.compilado.data.api.network.response

import com.example.compilado.domain.model.UserModel
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email")val email: String
) {
    fun toDomain(): UserModel {
        return UserModel(
            id =  id,
            name = name,
            email = email
        )
    }
}
