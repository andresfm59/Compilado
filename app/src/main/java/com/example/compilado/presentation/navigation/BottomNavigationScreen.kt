package com.example.compilado.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compilado.ui.theme.CompiladoTheme
import com.example.compilado.presentation.navigation.Items_bottom_nav.*


@Composable
fun BottomNavigationScreen(navController: NavHostController) {
    val menuItems = listOf(
        Items_bottom_nav_1,
        Items_bottom_nav_2,
        Items_bottom_nav_3,
        Items_bottom_nav_4
    )
    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                val selected = currentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = selected,
                    onClick = { navController.navigate(item.ruta) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()
    CompiladoTheme { BottomNavigationScreen(navController) }
}