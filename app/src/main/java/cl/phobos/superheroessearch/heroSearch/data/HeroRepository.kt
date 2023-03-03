package cl.phobos.superheroessearch.heroSearch.data

import cl.phobos.superheroessearch.heroSearch.data.network.HeroService
import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse

class HeroRepository {

    val api = HeroService()

    suspend fun searchHeroByName(name:String):HeroResponse?{
        return api.getHeroesByName(name)
    }
}