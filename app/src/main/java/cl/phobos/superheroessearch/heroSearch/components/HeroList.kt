package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
fun HeroList(viewModel: HeroSearchViewModel, navController: NavHostController){
    val heroList: List<Result> by viewModel.heroesList.observeAsState(initial = mutableListOf())
   LazyVerticalGrid(columns = GridCells.Fixed(2),horizontalArrangement = Arrangement.spacedBy(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)  ){
        items(heroList.size){
            HeroItem(navController = navController,heroList[it])
        }
   }
}