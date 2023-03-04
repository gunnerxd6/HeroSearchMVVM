package cl.phobos.superheroessearch.heroSearch

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.phobos.superheroessearch.heroSearch.data.domain.SearchHeroByNameUseCase
import cl.phobos.superheroessearch.heroSearch.data.network.response.Result
import kotlinx.coroutines.launch

class HeroSearchViewModel : ViewModel() {

    val searchHeroByNameUseCase = SearchHeroByNameUseCase()

    private val _searchText = MutableLiveData<String>()
    val searchText: LiveData<String> = _searchText

    private val _heroesList = MutableLiveData<List<Result>>()
    val heroesList: LiveData<List<Result>> = _heroesList

    fun onSearchTextChanged(value: String) {
        _searchText.value = value
    }

    fun searchHeroByName() {
        viewModelScope.launch {
            val result = searchHeroByNameUseCase(name = searchText.value!!)
            if (result!!.response == "error") {
                _heroesList.value = mutableListOf()

            } else {
                _heroesList.value = result.results
            }
           // _searchText.value=""
        }
    }


}