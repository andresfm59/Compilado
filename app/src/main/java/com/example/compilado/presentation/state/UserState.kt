package com.example.compilado.presentation.state

import com.example.compilado.domain.model.UserModel


sealed class UserListState {
    data object Loading:UserListState()
    data class Error(val error:String):UserListState()
    data class Success(val listUser: List<UserModel>):UserListState()
}