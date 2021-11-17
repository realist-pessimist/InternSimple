package com.example.rickandmorty.network.response

import java.io.Serializable

data class GenericError(
    val status: String,
    val message: String
): Serializable