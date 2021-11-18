package com.example.rickandmorty.di

import com.example.rickandmorty.ui.characters.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//TODO(Необходимо внедрить зависимость для ViewModel просмотра детальной информации о персонаже)
val viewModelModule = module {
    viewModel{
        CharactersViewModel(
            getCharactersUseCase = get()
        )
    }
}