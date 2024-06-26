package com.example.compilado.presentation.navigation.lateralMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compilado.R
import com.example.compilado.presentation.navigation.bottomBar.currentRoute
import com.example.compilado.presentation.navigation.item.Items_menu_lateral.*
import kotlinx.coroutines.launch

@Composable
fun LateralMenu(
    navController: NavController,
    drawerState: DrawerState,
    contenido: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val menuItems = listOf(
        Item_menu_lateral1,
        Item_menu_lateral2,
        Item_menu_lateral3,
        Item_menu_lateral4
    )
    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    null
                )
                menuItems.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier
                            .padding(10.dp),
                        icon = {
                            Icon(item.icon, null)
                        },
                        label = { Text(text = item.title) },
                        selected = currentRoute(navController) == item.ruta,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(item.ruta)
                        })
                }
            }
        }) {
        contenido()
    }
}