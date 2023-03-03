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
import cl.phobos.superheroessearch.heroSearch.components.HeroList
import cl.phobos.superheroessearch.heroSearch.components.SearchBox


@Composable
fun HeroSearchScreen(viewModel: HeroSearchViewModel) {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    text = "Hero search", fontSize = 20.sp, color = Color.White
                )
            }
        },
        content = {
            Content(Modifier.padding(it), viewModel)
        },

        )


}

@Composable
fun Content(modifier: Modifier, viewModel: HeroSearchViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        SearchBox(viewModel =viewModel)
        Spacer(modifier = Modifier.height(5.dp))
        HeroList(viewModel =viewModel)
    }
}




