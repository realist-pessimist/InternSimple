package com.example.rickandmorty.domain.services

import com.example.rickandmorty.data.ICharacterRepository
import com.example.rickandmorty.domain.usecases.GetCharactersUseCase

//TODO(Необходимо реализовать интерфейсы UseCases
// получения детальной информации о персонаже и фильтрации списка персонажей)
class CharacterService(
    private val characterRepository: ICharacterRepository
): GetCharactersUseCase {
    override suspend fun getCharacters() =
        characterRepository.getCharacters()?.items
}