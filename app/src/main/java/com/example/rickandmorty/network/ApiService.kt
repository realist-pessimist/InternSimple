package com.example.rickandmorty.network

import com.example.rickandmorty.models.CharacterResponse
import com.example.rickandmorty.network.response.GenericError
import com.example.rickandmorty.network.response.NetworkResponse
import retrofit2.http.GET

typealias GenericResponse<S> = NetworkResponse<S, GenericError>

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(): GenericResponse<CharacterResponse>
}