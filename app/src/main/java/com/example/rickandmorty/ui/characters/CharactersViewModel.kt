package com.example.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.Event
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import com.example.rickandmorty.domain.usecases.SearchCharactersUseCase
import com.example.rickandmorty.models.Character
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val searchCharactersUseCase: SearchCharactersUseCase
): ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _openCharacterEvent = MutableLiveData<Event<Pair<Int, String>>>()
    val openCharacterEvent: LiveData<Event<Pair<Int, String>>> = _openCharacterEvent

    init {
        loadCharacters()
    }

    fun onSearch(queryName: String){
        viewModelScope.launch {
            _characters.postValue(searchCharactersUseCase.filterCharacters(queryName))
            _dataLoading.value = false
        }
    }

    /**
     * Called by Data Binding.
     */
    fun openCharacter(characterId: Int, characterName: String) {
        _openCharacterEvent.value = Event(Pair(characterId, characterName))
    }

    fun onRefresh() {
        loadCharacters()
    }

    private fun loadCharacters() {
        _dataLoading.value = true
        viewModelScope.launch {
            _characters.postValue(getCharactersUseCase.getCharacters())
            _dataLoading.value = false
        }
    }
}