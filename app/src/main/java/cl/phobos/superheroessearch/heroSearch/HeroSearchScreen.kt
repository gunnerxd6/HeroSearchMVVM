package cl.phobos.superheroessearch.heroSearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cl.phobos.superheroessearch.ads.BannerAds
import cl.phobos.superheroessearch.heroSearch.components.HeroList
import cl.phobos.superheroessearch.heroSearch.components.SearchBox


@Composable
fun HeroSearchScreen(viewModel: HeroSearchViewModel, navController: NavHostController) {
    Scaffold(
        topBar = { TopBar()},
        content = {
            Content(Modifier.padding(it), viewModel,navController = navController)
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center
            ){
                BannerAds()
            }
        }

        )


}
@Composable
fun TopBar() {

    TopAppBar {
        Row(modifier = Modifier.padding(5.dp)){
            Text(
                text = "Hero search", fontSize = 20.sp, color = Color.White
            )
        }
    }
}

@Composable
fun Content(modifier: Modifier, viewModel: HeroSearchViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        SearchBox(viewModel =viewModel,navController = navController)
        Spacer(modifier = Modifier.height(5.dp))
        HeroList(viewModel =viewModel, navController= navController)
    }
}




