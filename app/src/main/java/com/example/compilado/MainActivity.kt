package com.example.compilado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.compilado.presentation.navigation.BottomNavigationScreen
import com.example.compilado.presentation.navigation.CompiladoNavigation
import com.example.compilado.presentation.viewmodel.UserViewModel
import com.example.compilado.ui.theme.CompiladoTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userViewModel: UserViewModel = viewModel()
            val state by userViewModel.state.collectAsState()
            val addUserState by userViewModel.addUserState.collectAsState()
            LaunchedEffect(Unit) {
                userViewModel.fetchUsers()
            }
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationScreen(navController) }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ){
            CompiladoNavigation(navController = navController)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    CompiladoTheme { MainScreen() }
}
