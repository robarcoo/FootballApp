package com.example.domain.usecases.auth.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface SendCodeToPhoneUseCase {
    fun execute(phone: String): Flow<Result>
}