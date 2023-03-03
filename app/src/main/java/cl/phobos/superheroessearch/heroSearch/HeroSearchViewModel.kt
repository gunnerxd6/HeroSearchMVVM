package cl.phobos.superheroessearch.heroSearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeroSearchViewModel : ViewModel() {

    private val _searchText = MutableLiveData<String>()
    val searchText: LiveData<String> = _searchText

    fun onSearchTextChanged(value:String){
        _searchText.value = value
    }

}