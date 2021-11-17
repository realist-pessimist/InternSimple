package com.example.rickandmorty.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CharacterResponse (
    @SerializedName("results")
    val items: List<Character>
): Serializable