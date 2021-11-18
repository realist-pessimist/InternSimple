package com.example.rickandmorty.domain.services

import com.example.rickandmorty.data.ICharacterRepository
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase

class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase{
    override suspend fun getCharacters() =
        characterRepository.getCharacters()?.items
}