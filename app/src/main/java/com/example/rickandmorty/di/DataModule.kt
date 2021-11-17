package com.example.rickandmorty.di

import com.example.rickandmorty.data.CharacterRepository
import com.example.rickandmorty.data.ICharacterRepository
import org.koin.dsl.module

val dataModule = module {
    factory<ICharacterRepository> { CharacterRepository(apiService = get()) }
}