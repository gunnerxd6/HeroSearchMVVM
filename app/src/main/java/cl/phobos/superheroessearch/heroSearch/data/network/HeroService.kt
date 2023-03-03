package cl.phobos.superheroessearch.heroSearch.data.network

import android.util.Log
import cl.phobos.superheroessearch.core.network.RetrofitHelper
import cl.phobos.superheroessearch.heroSearch.data.network.response.HeroResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroService {

    var retrofit = RetrofitHelper.getRetrofit()

    suspend fun getHeroesByName(name:String) :HeroResponse?{
       return withContext(Dispatchers.IO){
           val response = retrofit.create(HeroClient::class.java).getHeroesByName("search/$name")
           Log.i("Response",response.body()!!.response)
           response.body()
        }

    }

}