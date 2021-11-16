package com.example.internsimple.domain.services

import com.example.internsimple.data.ICharacterRepository
import com.example.internsimple.domain.usecases.GetCharacterDetailUseCase
import com.example.internsimple.domain.usecases.GetCharactersUseCase
import com.example.internsimple.models.Character

class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase, GetCharacterDetailUseCase {
    override suspend fun getCharacters() = characterRepository.getCharacters()

    override suspend fun getCharacter(id: Int) = characterRepository.getCharacter(id)
}