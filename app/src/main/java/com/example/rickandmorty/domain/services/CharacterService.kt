package com.example.rickandmorty.domain.services

import com.example.rickandmorty.data.ICharacterRepository
import com.example.rickandmorty.domain.usecases.GetCharacterDetailUseCase
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase
import com.example.rickandmorty.domain.usecases.SearchCharactersUseCase

class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase, GetCharacterDetailUseCase, SearchCharactersUseCase {
    override suspend fun getCharacters() =
        characterRepository.getCharacters()?.items

    override suspend fun getCharacter(id: Int) =
        characterRepository.getCharacter(id)

    override suspend fun filterCharacters(queryName: String) =
        characterRepository.filterCharacters(queryName)?.items
}