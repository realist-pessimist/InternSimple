package com.example.internsimple.domain.usecases

import com.example.internsimple.models.Character

interface GetCharactersUseCase {
    suspend fun getCharacters(): List<Character>?
}