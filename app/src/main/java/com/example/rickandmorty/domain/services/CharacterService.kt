package com.example.rickandmorty.domain.services

import com.example.rickandmorty.data.ICharacterRepository
import com.example.rickandmorty.domain.usecases.GetCharacterDetailUseCase
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase

class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase, GetCharacterDetailUseCase {
    override suspend fun getCharacters() = characterRepository.getCharacters()?.results

    override suspend fun getCharacter(id: Int) = characterRepository.getCharacter(id)
}