package com.example.internsimple.data

import com.example.internsimple.model.Character

interface ICharacterRepository {
    suspend fun getCharacters(): List<Character>?
}