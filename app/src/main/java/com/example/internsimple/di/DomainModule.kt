package com.example.internsimple.di

import com.example.internsimple.domain.services.CharacterService
import com.example.internsimple.domain.usecases.GetCharacterDetailUseCase
import com.example.internsimple.domain.usecases.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCharactersUseCase> { CharacterService(characterRepository = get()) }
    factory<GetCharacterDetailUseCase> { CharacterService(characterRepository = get()) }
}