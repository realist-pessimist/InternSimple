package com.example.rickandmorty.di

import com.example.rickandmorty.domain.services.CharacterService
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import org.koin.dsl.module

//TODO(Необходимо внедрить UseCase(фильтрация и получение персонажа по id)
// зависимости для CharacterService)
val domainModule = module {
    factory<GetCharactersUseCase> { CharacterService(characterRepository = get()) }
}