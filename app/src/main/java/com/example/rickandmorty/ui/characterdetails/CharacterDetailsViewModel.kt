package com.example.rickandmorty.ui.characterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.usecases.GetCharacterDetailUseCase
import com.example.rickandmorty.models.Character
import kotlinx.coroutines.launch
import java.util.*

class CharacterDetailsViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
): ViewModel() {
    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun onSetupUi(id: Int) {
        _dataLoading.value = true
        viewModelScope.launch {
            _character.postValue(getCharacterDetailUseCase.getCharacter(id))
            _dataLoading.value = false
        }
    }
}