package com.example.internsimple.di

import com.example.internsimple.ui.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        CharactersViewModel(
            getCharactersUseCase = get()
        )
    }
}