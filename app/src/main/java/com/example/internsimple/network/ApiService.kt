package com.example.internsimple.network

import com.example.internsimple.model.Character
import retrofit2.http.GET

typealias GenericResponse<S> = NetworkResponse<S, GenericError>

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(): GenericResponse<List<Character>>
}