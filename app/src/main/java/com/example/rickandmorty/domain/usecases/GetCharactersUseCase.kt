package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.models.Character

interface GetCharactersUseCase {
    suspend fun getCharacters(): List<Character>?
}