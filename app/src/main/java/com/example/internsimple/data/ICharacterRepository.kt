package com.example.internsimple.data

import com.example.internsimple.models.Character

interface ICharacterRepository {
    suspend fun getCharacters(): List<Character>?
    suspend fun getCharacter(id: Int): Character?
}