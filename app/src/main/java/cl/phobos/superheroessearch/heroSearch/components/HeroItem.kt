package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cl.phobos.superheroessearch.heroSearch.data.network.response.Result
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson

@Composable
fun HeroItem(navController: NavHostController, hero: Result) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(10.dp))
        .clickable {
            val heroJson: String = Gson()
                .toJson(hero)
                .toString()
                .replace("/", "$$$")
            navController.navigate("hero_details/${heroJson}")
        }, elevation = 15.dp
    ) {
        Column(
            modifier = Modifier.height(200.dp)
        ) {

            Box(modifier = Modifier.padding(5.dp)) {
                Text(
                    modifier = Modifier.align(alignment = Alignment.TopCenter),
                    text = hero.name, fontSize = 20.sp
                )
            }
                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),

                    painter = rememberAsyncImagePainter(hero.image.url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop

                )


        }
    }
}