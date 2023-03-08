package cl.phobos.superheroessearch.heroDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter


@Composable
fun HeroDetailsScreen(
    viewModel: HeroDetailsViewModel, navController: NavHostController, hero: String
) {

    Scaffold(content = { Content(modifier = Modifier.padding(it), viewModel = viewModel) })
    viewModel.decodeHero(hero.replace("$$$", "/"))
}


@Composable
fun Content(modifier: Modifier, viewModel: HeroDetailsViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)

    ) {
        item {
            Text(viewModel.hero.value!!.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .align(Center)
                        .height(200.dp)
                        .width(200.dp),
                    painter = rememberAsyncImagePainter(viewModel.hero.value!!.image.url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Column {
                Text("Info:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Full name: ${viewModel.hero.value!!.biography.fullName}")
                Text("Gender: ${viewModel.hero.value!!.appearance.gender}")
                Text("Height: ${viewModel.hero.value!!.appearance.height[1]}")
                Text("Weight: ${viewModel.hero.value!!.appearance.weight[1]}")

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text("Aliases:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }



        items(
            viewModel.hero.value!!.biography.aliases.size
        ) {
            Text(viewModel.hero.value!!.biography.aliases[it])
        }



        item {
            Spacer(modifier = Modifier.height(10.dp))
            Text("PowerStats:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Column {
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.intelligence,
                    statName = "Intelligence",
                    color = Color.Green
                )
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.strength,
                    statName = "Strength",
                    color = Color.Red
                )
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.speed,
                    statName = "Speed",
                    color = Color.Blue
                )
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.durability,
                    statName = "Durability",
                    color = Color.Magenta
                )
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.power,
                    statName = "Power",
                    color = Color.Yellow
                )
                PowerStat(
                    statValue = viewModel.hero.value?.powerstats?.combat,
                    statName = "Combat",
                    color = Color.Gray
                )
            }

        }

    }

}