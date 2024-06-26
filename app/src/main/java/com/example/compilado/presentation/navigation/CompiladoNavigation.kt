package com.example.compilado.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compilado.presentation.ui.screen.HomeApp
import com.example.compilado.presentation.ui.screen.HomeScreen
import com.example.compilado.presentation.ui.screen.NotificationScreen
import com.example.compilado.presentation.ui.screen.ProfileScreen
import com.example.compilado.presentation.ui.screen.SettingScreen

@Composable
fun CompiladoNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.name,
    ) {
        composable(NavScreen.HomeScreen.name){
            HomeApp()
        }
        composable(NavScreen.ProfileScreen.name){
            ProfileScreen()
        }
        composable(NavScreen.SettingScreen.name){
            SettingScreen()
        }
        composable(NavScreen.NotificationScreen.name){
            NotificationScreen()
        }
    }
}