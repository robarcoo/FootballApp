package com.example.domain.usecases.auth.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface CheckRecoveryCodeUseCase {
    fun execute(code: Int): Flow<Result>
}