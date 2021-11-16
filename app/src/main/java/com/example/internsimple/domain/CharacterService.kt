package com.example.internsimple.domain

import com.example.internsimple.data.ICharacterRepository

class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase {
    override suspend fun getCharacters() = characterRepository.getCharacters()
}