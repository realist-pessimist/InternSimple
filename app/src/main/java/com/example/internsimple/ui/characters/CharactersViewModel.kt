package com.example.internsimple.ui.characters

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

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun onSetupUi() {
        _dataLoading.value = true
        viewModelScope.launch {
            _characters.postValue(getCharactersUseCase.getCharacters())
            _dataLoading.value = false
        }
    }
}