package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.models.Character

interface SearchCharactersUseCase {
    suspend fun filterCharacters(queryName: String): List<Character>?
}