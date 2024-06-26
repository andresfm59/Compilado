package com.example.compilado.presentation.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compilado.R
import com.example.compilado.ui.theme.CompiladoTheme
/*
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            //painter = painterResource(id = R.drawable.img_transfer)
            Icons.Default.Home,
            contentDescription = null
        )
    }
}
*/

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        HomeSection(
            title = R.string.favorite_collections
        ) {
            AlignYourBodyRow()
        }
        HomeSection(
            title = R.string.favorite_collections
        ) {
            FavoriteCollectionsGrid()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeAppPreview() {
    CompiladoTheme { HomeApp() }
}

@Composable
fun HomeApp() {
    Scaffold(
        //bottomBar = { //BottomNavigation() }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun ScreenContentPreview() {
    CompiladoTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun HomeSectionPreview() {
    CompiladoTheme {
        HomeSection(
            title = R.string.favorite_collections
        ) {
            AlignYourBodyRow()
        }
    }
}

@Composable
private fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(id = title),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun AlignYourBodyRowPreview() {
    CompiladoTheme { AlignYourBodyRow() }
}

@Composable
private fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun AlignYourBodyElementPreview() {
    CompiladoTheme {
        AlignYourBodyElement(
            drawable = R.drawable.ic_launcher_background,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(text),
            //style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun FavoriteCollectionCardPreview() {
    CompiladoTheme {
        FavoriteCollectionCard(
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
private fun FavoriteCollectionsGridPreview() {
    CompiladoTheme { FavoriteCollectionsGrid() }
}


@Composable
private fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier =  modifier.height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ){
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text)
        }
    }
}

@Composable
private fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ){
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
                //.clip(MaterialTheme.shapes.small)
            )
            Text(stringResource(id = text),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

}

//private val dataUserList = List<UserModel>().map { DrawableStringPair(it.name, it.email) }
private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

