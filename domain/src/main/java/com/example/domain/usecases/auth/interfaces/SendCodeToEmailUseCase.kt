package com.example.domain.usecases.auth.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface SendCodeToEmailUseCase {
    fun execute(email: String): Flow<Result>
}