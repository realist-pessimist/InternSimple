package com.example.rickandmorty.data

import com.example.rickandmorty.network.ApiService
import com.example.rickandmorty.network.response.NetworkResponse

class CharacterRepository(private val apiService: ApiService): ICharacterRepository {
    override suspend fun getCharacters() =
         when(val response = apiService.getCharacters()) {
             is NetworkResponse.Success -> response.body
             is NetworkResponse.ApiError -> null
             is NetworkResponse.NetworkError -> null
             is NetworkResponse.UnknownError -> null
         }
    //TODO(Необходимо добавить реализацию методов получения персонажа по id и фильтрации списка)
}