package com.example.domain.usecases.field.interfaces

import com.example.domain.repositories.CachePolicy
import kotlinx.coroutines.flow.Flow
import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass

interface PutFieldUseCase {
    fun execute(id : Int, data : FieldClass, cachePolicy : CachePolicy) : Flow<Result>
}