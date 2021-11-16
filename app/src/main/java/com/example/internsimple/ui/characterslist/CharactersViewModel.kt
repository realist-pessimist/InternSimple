package com.example.internsimple.ui.characterslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internsimple.domain.usecases.GetCharactersUseCase
import com.example.internsimple.models.Character
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    fun onSetupUi() {
        viewModelScope.launch {
            _characters.postValue(getCharactersUseCase.getCharacters())
        }
    }
}