package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.models.Character

interface GetCharacterDetailUseCase {
    suspend fun getCharacter(id: Int): Character?
}