package com.example.compilado.presentation.navigation.item

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compilado.presentation.navigation.bottomBar.NavScreen

sealed class Items_bottom_nav (
    val icon: ImageVector,
    val title: String,
    val ruta: String
){
    object Items_bottom_nav_1: Items_bottom_nav(
        Icons.Outlined.Home,
        "Home",
        NavScreen.HomeScreen.name
    )
    object Items_bottom_nav_2: Items_bottom_nav(
        Icons.Outlined.Person,
        "Profile",
        NavScreen.ProfileScreen.name
    )
    object Items_bottom_nav_3: Items_bottom_nav(
        Icons.Outlined.Settings,
        "Setting",
        NavScreen.SettingScreen.name
    )
    object Items_bottom_nav_4: Items_bottom_nav(
        Icons.Outlined.Notifications,
        "Notifications",
        NavScreen.NotificationScreen.name
    )
}