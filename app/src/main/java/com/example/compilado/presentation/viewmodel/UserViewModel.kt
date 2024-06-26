package com.example.compilado.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compilado.domain.model.UserModel
import com.example.compilado.domain.usecase.ExecuteUserUseCase
import com.example.compilado.domain.usecase.GetUserUseCase
import com.example.compilado.presentation.state.State
import com.example.compilado.presentation.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor (
    private val getUserUseCase: GetUserUseCase,
    private val executeUserUseCase: ExecuteUserUseCase
): ViewModel() {

    private var _state = MutableStateFlow<UserListState>(UserListState.Loading)
    val state: StateFlow<UserListState> = _state

    private val _addUserState = MutableStateFlow<State<UserModel>>(State.Loading)
    val addUserState: StateFlow<State<UserModel>> = _addUserState

    //private val _error = MutableLiveData<String?>()
    //val error: LiveData<String?> get() = _error

    fun fetchUsers() {
        viewModelScope.launch{
            _state.value = UserListState.Loading
            val result = withContext(Dispatchers.IO) { getUserUseCase() }
            if (result != null) {
                _state.value = UserListState.Success(result)
            } else {
                _state.value = UserListState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }


    fun addUser(userModel: UserModel) {
        viewModelScope.launch {
            _addUserState.value = State.Loading
            val response = withContext(Dispatchers.IO) {executeUserUseCase(userModel)}
            if (response != null) {
                _addUserState.value = State.Success(response)
            } else {
                _addUserState.value = State.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }

}

