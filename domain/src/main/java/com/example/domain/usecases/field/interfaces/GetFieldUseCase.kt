package com.example.domain.usecases.field.interfaces

import com.example.domain.repositories.CachePolicy
import kotlinx.coroutines.flow.Flow
import com.example.domain.models.Result

interface GetFieldUseCase {
    fun execute(id : Int, cachePolicy : CachePolicy) : Flow<Result>
}