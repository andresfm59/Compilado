package com.example.compilado.presentation.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compilado.domain.model.UserModel
import com.example.compilado.presentation.state.State
import com.example.compilado.presentation.state.UserListState
import com.example.compilado.presentation.ui.HomeActivity
import com.example.compilado.presentation.viewmodel.UserViewModel
import com.example.compilado.ui.theme.CompiladoTheme


@Composable
fun MainScreen_before(userViewModel: UserViewModel) {
    val state by userViewModel.state.collectAsState()
    val addUserState by userViewModel.addUserState.collectAsState()
    when (state) {
        is UserListState.Loading -> LoadingState()
        is UserListState.Error -> ErrorState((state as UserListState.Error).error)
        is UserListState.Success -> SuccessState(state as UserListState.Success, userViewModel)
        else -> {}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        when (addUserState) {
            //is State.Loading -> CircularProgressIndicator()
            is State.Error -> ErrorState((addUserState as State.Error).error)
            is State.Success -> {
                val newUser = (addUserState as State.Success<UserModel>).data
                Text(text = "New User: ${newUser.name} - ${newUser.email}")
            }
            else -> { /* No operation */ }
        }
        //IniUI(userViewModel)
    }
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Go to New Activity")
    }
}
/*
@Composable
fun IniUI(userViewModel: UserViewModel){
    Button(onClick = {
        val userModel = UserModel(id = 0, name = "John Doe", email = "john.doe@example.com")
        userViewModel.addUser(userModel)
    }) {
        Text(text = "Add User")
    }
}
@Composable
fun initState(userViewModel: UserViewModel){
    val addUserState by userViewModel.addUserState.collectAsState()
    when (addUserState) {
        is State.Loading -> LoadingState()
        is State.Error -> ErrorState((addUserState as State.Error).error)
        is State.Success -> {
            val newUser = (addUserState as State.Success<UserModel>).data
            userViewModel.addUser(newUser)

            Text(text = "New User: ${newUser.name} - ${newUser.email}")
        }
    }
}*/


@Composable
fun SuccessState(state: UserListState.Success, userViewModel: UserViewModel) {
    val users = state.listUser
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        users.forEach { user ->
            UserItem(user = user)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun UserItem(user: UserModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "ID: ${user.id}", fontSize = 16.sp)
        Text(text = "Name: ${user.name}", fontSize = 16.sp)
        Text(text = "Email: ${user.email}", fontSize = 16.sp)
    }
}

@Composable
fun LoadingState() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorState(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    //CompiladoTheme{SearchBar(Modifier.padding(8.dp))}
    CompiladoTheme{ErrorState("HOLA")}
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon( Icons.Default.Search, contentDescription = null )
        },
        placeholder = {
            Text("Buscar")
        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth())

}