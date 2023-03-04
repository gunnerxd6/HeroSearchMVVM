package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cl.phobos.superheroessearch.heroSearch.HeroSearchViewModel
import cl.phobos.superheroessearch.heroSearch.data.network.response.Result
import cl.phobos.superheroessearch.models.Routes
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson

@Composable
fun HeroList(viewModel: HeroSearchViewModel, navController: NavHostController) {
    val heroList: List<Result> by viewModel.heroesList.observeAsState(initial = mutableListOf())
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(heroList.size) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .clickable {
                    val heroJson:String = Gson().toJson(heroList[it]).toString()
                        .replace("/", "$$$")
                    navController.navigate("hero_details/${heroJson}")
                }, elevation = 15.dp) {
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        modifier = Modifier

                            .weight(2f)
                            .fillMaxWidth(),
                        painter = rememberAsyncImagePainter(heroList[it].image.url),
                        contentDescription = null,
                        contentScale = ContentScale.Crop

                    )
                    Column(
                        modifier = Modifier
                            .weight(4f)
                            .fillMaxWidth()
                            .padding(start = 15.dp)
                    ) {
                        Text(text = heroList[it].name)

                    }
                }
            }
            Divider(Modifier.height(1.dp))
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}