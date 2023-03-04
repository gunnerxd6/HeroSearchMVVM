package cl.phobos.superheroessearch.models

sealed class Routes(val route:String){

    object HeroSearchRoute:Routes("hero_search")
    object HeroDetailsRoute:Routes("hero_details")
}
