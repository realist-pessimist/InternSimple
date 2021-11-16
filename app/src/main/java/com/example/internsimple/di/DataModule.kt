package com.example.internsimple.di

import com.example.internsimple.data.CharacterRepository
import com.example.internsimple.data.ICharacterRepository
import org.koin.dsl.module

val dataModule = module {
    factory<ICharacterRepository> { CharacterRepository(apiService = get()) }
}