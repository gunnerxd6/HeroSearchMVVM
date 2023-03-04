package cl.phobos.superheroessearch.heroDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.phobos.superheroessearch.heroSearch.data.network.response.Result
import com.google.gson.Gson

class HeroDetailsViewModel: ViewModel() {

    private val _heroJson = MutableLiveData<String>()
    val heroJson: LiveData<String> = _heroJson

    private val _hero = MutableLiveData<Result>()
    val hero: LiveData<Result> = _hero;


    fun decodeHero(heroJson:String){
        val hero: Result = Gson().fromJson(heroJson,Result::class.java)
        _hero.value = hero
    }



}