package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.phobos.superheroessearch.heroSearch.HeroSearchViewModel


@Composable
fun SearchBox(viewModel: HeroSearchViewModel) {

    val searchText:String by viewModel.searchText.observeAsState(initial = "")

    Row(
        verticalAlignment = Alignment.CenterVertically

    ) {
        OutlinedTextField(
            modifier = Modifier
                .weight(4f)
                .height(60.dp),
            value = searchText,
            onValueChange = {viewModel.onSearchTextChanged(it)},
            label = { Text(text ="Enter name") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Box") }
        )

        Button(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .weight(2f)
                .padding(start = 5.dp)
                .height(40.dp),
            onClick = {}){
            Text("Search")
        }
    }
}