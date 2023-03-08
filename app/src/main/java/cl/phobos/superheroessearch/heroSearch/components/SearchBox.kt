package cl.phobos.superheroessearch.heroSearch.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cl.phobos.superheroessearch.heroSearch.HeroSearchViewModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBox(viewModel: HeroSearchViewModel, navController: NavHostController) {

    val searchText: String by viewModel.searchText.observeAsState(initial = "")
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(
        verticalAlignment = Alignment.CenterVertically

    ) {
        OutlinedTextField(modifier = Modifier
            .weight(4f)
            .height(60.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                viewModel.searchHeroByName()
                keyboardController?.hide()
            }),
            value = searchText,
            onValueChange = { viewModel.onSearchTextChanged(it) },
            label = { Text(text = "Enter name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = "Search Box"
                )
            })
        val context = LocalContext.current
        Button(modifier = Modifier
            .align(alignment = Alignment.CenterVertically)
            .weight(2f)
            .padding(start = 5.dp)
            .height(40.dp), onClick = {
            viewModel.searchHeroByName()
            keyboardController?.hide()
        }) {
            Text("Search")
        }
    }
}