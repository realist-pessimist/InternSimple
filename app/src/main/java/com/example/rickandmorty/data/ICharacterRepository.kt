package com.example.rickandmorty.data

import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.CharacterResponse

interface ICharacterRepository {
    suspend fun getCharacters(): CharacterResponse?
    suspend fun getCharacter(id: Int): Character?
}