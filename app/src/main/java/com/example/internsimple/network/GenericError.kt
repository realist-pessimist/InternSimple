package com.example.internsimple.network

import java.io.Serializable

data class GenericError(
    val status: String,
    val message: String
): Serializable