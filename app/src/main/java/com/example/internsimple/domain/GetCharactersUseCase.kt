package com.example.internsimple.domain

import com.example.internsimple.model.Character

interface GetCharactersUseCase {
    suspend fun getCharacters(): List<Character>?
}