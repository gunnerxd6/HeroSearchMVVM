package cl.phobos.superheroessearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.phobos.superheroessearch.heroDetails.HeroDetailsScreen
import cl.phobos.superheroessearch.heroDetails.HeroDetailsViewModel
import cl.phobos.superheroessearch.heroSearch.HeroSearchScreen
import cl.phobos.superheroessearch.heroSearch.HeroSearchViewModel
import cl.phobos.superheroessearch.models.Routes
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
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.HeroSearchRoute.route
                    ) {
                        composable(Routes.HeroSearchRoute.route) {
                            HeroSearchScreen(
                                viewModel = HeroSearchViewModel(),
                                navController = navigationController
                            )
                        }
                        composable("hero_details/{hero}") { backStackEntry ->
                            HeroDetailsScreen(
                                viewModel = HeroDetailsViewModel(),
                                navController = navigationController,
                                backStackEntry.arguments?.getString("hero")!!
                            )
                        }
                    }
                }
            }
        }
    }


}
