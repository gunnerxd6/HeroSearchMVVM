package cl.phobos.superheroessearch.heroSearch.data.domain

import cl.phobos.superheroessearch.heroSearch.data.HeroRepository
import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse

class SearchHeroByNameUseCase {

    private val respository = HeroRepository()

    suspend operator fun invoke(name:String):HeroResponse?{
        return respository.searchHeroByName(name)
    }
}