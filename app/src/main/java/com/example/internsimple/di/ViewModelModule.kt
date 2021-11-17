package com.example.internsimple.di

import com.example.internsimple.ui.characterdetails.CharacterDetailsViewModel
import com.example.internsimple.ui.characters.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        CharactersViewModel(
            getCharactersUseCase = get()
        )
    }
    viewModel{
        CharacterDetailsViewModel(
            getCharacterDetailUseCase = get()
        )
    }
}