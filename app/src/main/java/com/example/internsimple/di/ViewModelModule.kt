package com.example.internsimple.di

import com.example.internsimple.ui.characterdetail.CharacterDetailViewModel
import com.example.internsimple.ui.characterslist.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        CharactersViewModel(
            getCharactersUseCase = get()
        )
    }
    viewModel{
        CharacterDetailViewModel(
            getCharacterDetailUseCase = get()
        )
    }
}