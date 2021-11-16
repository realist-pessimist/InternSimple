package com.example.internsimple.ui.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internsimple.domain.usecases.GetCharacterDetailUseCase
import com.example.internsimple.models.Character
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
): ViewModel() {
    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character

    fun onSetupUi(id: Int) {
        viewModelScope.launch {
            _character.postValue(getCharacterDetailUseCase.getCharacter(id))
        }
    }
}