package cl.phobos.superheroessearch.heroSearch.data.network

import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface HeroClient {
    @GET
    suspend fun getHeroesByName(@Url url:String):Response<HeroResponse?>
}