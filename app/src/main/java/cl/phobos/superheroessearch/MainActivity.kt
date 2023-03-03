package cl.phobos.superheroessearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.phobos.superheroessearch.heroSearch.HeroSearchScreen
import cl.phobos.superheroessearch.heroSearch.HeroSearchViewModel
import cl.phobos.superheroessearch.ui.theme.SuperHeroesSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   HeroSearchScreen(HeroSearchViewModel())
                }
            }
        }
    }
}