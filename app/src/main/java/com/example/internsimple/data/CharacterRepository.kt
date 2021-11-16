package com.example.internsimple.data

import com.example.internsimple.model.Character
import com.example.internsimple.network.ApiService
import com.example.internsimple.network.NetworkResponse

class CharacterRepository(private val apiService: ApiService): ICharacterRepository {
    override suspend fun getCharacters(): List<Character>? =
         when(val response = apiService.getCharacters()) {
             is NetworkResponse.Success -> response.body
             is NetworkResponse.ApiError -> null
             is NetworkResponse.NetworkError -> null
             is NetworkResponse.UnknownError -> null
         }
}