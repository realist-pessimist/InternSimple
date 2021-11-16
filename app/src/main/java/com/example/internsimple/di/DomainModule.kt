package com.example.internsimple.di

import com.example.internsimple.domain.CharacterService
import com.example.internsimple.domain.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCharactersUseCase> { CharacterService(characterRepository = get()) }
}