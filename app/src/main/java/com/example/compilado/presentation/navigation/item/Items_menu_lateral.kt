package com.example.compilado.presentation.navigation.item

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compilado.presentation.navigation.NavScreen

sealed class Items_menu_lateral(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object Item_menu_lateral1 : Items_menu_lateral(
        Icons.Outlined.RealEstateAgent,
        "CardTranfer",
        NavScreen.HomeScreen.name,
    )
    object Item_menu_lateral2 : Items_menu_lateral(
        Icons.Outlined.CreditCard,
        "CreditCard",
        NavScreen.ProfileScreen.name,
    )
    object Item_menu_lateral3 : Items_menu_lateral(
        Icons.Outlined.PriceCheck,
        "PriceCheck",
        NavScreen.SettingScreen.name,
    )
    object Item_menu_lateral4 : Items_menu_lateral(
        Icons.Outlined.AttachMoney,
        "AttachMoney",
        NavScreen.NotificationScreen.name,
    )
}