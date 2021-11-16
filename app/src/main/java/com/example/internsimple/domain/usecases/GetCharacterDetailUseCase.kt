package com.example.internsimple.domain.usecases

import com.example.internsimple.models.Character

interface GetCharacterDetailUseCase {
    suspend fun getCharacter(id: Int): Character?
}