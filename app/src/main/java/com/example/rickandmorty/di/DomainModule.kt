package com.example.rickandmorty.di

import com.example.rickandmorty.domain.services.CharacterService
import com.example.rickandmorty.domain.usecases.GetCharacterDetailUseCase
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import com.example.rickandmorty.domain.usecases.SearchCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCharactersUseCase> { CharacterService(characterRepository = get()) }
    factory<GetCharacterDetailUseCase> { CharacterService(characterRepository = get()) }
    factory<SearchCharactersUseCase> { CharacterService(characterRepository = get()) }
}