package com.example.compilado.presentation.navigation.tabMov

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.compilado.MainScreen
import com.example.compilado.presentation.navigation.item.Items_tab_mov
import com.example.compilado.presentation.navigation.item.Items_tab_mov.*
import com.example.compilado.ui.theme.CompiladoTheme
import kotlinx.coroutines.launch

@Composable
fun TabMovScreen() {
    val tabs = listOf(
        tab_Item_1,
        tab_Item_2,
        tab_Item_3
    )
    val pagerState = rememberPagerState(pageCount = {
        tabs.size
    })
    Column {
        Tabs(tabs, pagerState)
        TabsContent(tabs, pagerState)
    }
}

@Composable
fun TabsContent(
    tabs: List<Items_tab_mov>,
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState
    ) {
        page ->
        tabs[page].screen()

    }

}

@Composable
fun Tabs(
    tabs: List<Items_tab_mov>,
    pagerState: PagerState
) {
    val selectedTab = pagerState.currentPage
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = selectedTab) {
        tabs.forEachIndexed { index, items ->
            Tab(
                selected = selectedTab == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = items.title) },
                icon = {
                    Icon(
                        if (index == selectedTab)
                            items.iconSelected
                        else
                            items.iconUnselected,
                        items.title
                    )

                }
            )

        }
    }

}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TabMovPreview() {
    CompiladoTheme { TabMovScreen() }
}
