package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeroList(){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(30){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                elevation = 15.dp) {
                Row {
                    Icon(
                        modifier = Modifier.weight(2f).fillMaxSize(),
                        imageVector = Icons.Default.Person, contentDescription = "Hero Image")
                    Column(
                        modifier = Modifier.weight(4f)
                    ) {
                        Text(text = "Batman")
                        Text(text = "Real name: Bruce Wayne")
                    }
                }
            }
            Divider(Modifier.height(1.dp))
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}