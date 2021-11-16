package com.example.internsimple.network

import com.example.internsimple.models.Character
import com.example.internsimple.network.response.GenericError
import com.example.internsimple.network.response.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

typealias GenericResponse<S> = NetworkResponse<S, GenericError>

interface ApiService {
    @GET("api/character")
    suspend fun getCharacters(): GenericResponse<List<Character>>

    @GET("api/character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): GenericResponse<Character>
}