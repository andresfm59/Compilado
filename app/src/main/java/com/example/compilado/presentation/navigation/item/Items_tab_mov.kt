package com.example.compilado.presentation.navigation.item

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compilado.presentation.navigation.tabMov.Item1
import com.example.compilado.presentation.navigation.tabMov.Item2
import com.example.compilado.presentation.navigation.tabMov.Item3

sealed class Items_tab_mov(
    var title: String,
    var iconSelected: ImageVector,
    var iconUnselected: ImageVector,
    var screen: @Composable () -> Unit
) {
    object tab_Item_1 : Items_tab_mov(
        "Item 1",
        Icons.Filled.EmojiEmotions,
        Icons.Outlined.EmojiEmotions,
        { Item1() }
    )
    object tab_Item_2 : Items_tab_mov(
        "Item 2",
        Icons.Filled.EmojiEmotions,
        Icons.Outlined.EmojiEmotions,
        { Item2() }
    )
    object tab_Item_3 : Items_tab_mov(
        "Item 3",
        Icons.Filled.EmojiEmotions,
        Icons.Outlined.EmojiEmotions,
        { Item3() }
    )
}