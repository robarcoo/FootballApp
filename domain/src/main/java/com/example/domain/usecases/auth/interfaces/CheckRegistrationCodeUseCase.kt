package com.example.domain.usecases.auth.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface CheckRegistrationCodeUseCase {
    fun execute(code: String): Flow<Result>
}