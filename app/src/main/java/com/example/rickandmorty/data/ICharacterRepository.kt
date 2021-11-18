package com.example.rickandmorty.data

import com.example.rickandmorty.models.CharacterResponse

interface ICharacterRepository {
    suspend fun getCharacters(): CharacterResponse?
    //TODO(Необходимо добавить методы фильтрации и получения персонажа по id)
}