package com.example.rickandmorty.di

import com.example.rickandmorty.domain.services.CharacterService
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetCharactersUseCase> { CharacterService(characterRepository = get()) }
 }