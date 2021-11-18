package com.example.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.Event
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import com.example.rickandmorty.models.Character
import kotlinx.coroutines.launch

//TODO(Необходимо доработать функционал ViewModel с учетом возможности фильтрации персонажей по имени)
class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
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