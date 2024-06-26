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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compilado.presentation.navigation.bottomBar.BottomNavigationScreen
import com.example.compilado.presentation.navigation.bottomBar.CompiladoNavigation
import com.example.compilado.presentation.navigation.lateralMenu.LateralMenu
import com.example.compilado.presentation.navigation.lateralMenu.TopBar
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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    LateralMenu(
        navController = navController,
        drawerState = drawerState
    ) {
        BottomBarNav(navController, drawerState)
    }
}

@Composable
fun BottomBarNav(
    navController: NavHostController,
    drawerState: DrawerState
) {
    Scaffold(
        topBar = { TopBar(drawerState) },
        bottomBar = { BottomNavigationScreen(navController) }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            CompiladoNavigation(navController = navController)
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    CompiladoTheme { BottomBarNav(navController, drawerState) }
}
