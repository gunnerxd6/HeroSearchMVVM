package cl.phobos.superheroessearch.heroSearch.data.domain

import cl.phobos.superheroessearch.heroSearch.data.HeroRepository
import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse
import javax.inject.Inject

class SearchHeroByNameUseCase @Inject constructor(private val repository: HeroRepository){

    suspend operator fun invoke(name:String):HeroResponse?{
        return repository.searchHeroByName(name)
    }
}