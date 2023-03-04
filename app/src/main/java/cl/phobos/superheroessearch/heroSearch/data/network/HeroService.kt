package cl.phobos.superheroessearch.heroSearch.data.network

import android.util.Log
import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class HeroService @Inject constructor(private val heroClient: HeroClient){



    suspend fun getHeroesByName(name:String) :HeroResponse?{
       return withContext(Dispatchers.IO){
           val response = heroClient.getHeroesByName("search/$name")
           Log.i("Response",response.body()!!.response)
           response.body()
        }

    }

}