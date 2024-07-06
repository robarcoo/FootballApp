package com.example.domain.usecases.field.interfaces

import com.example.domain.repositories.CachePolicy
import kotlinx.coroutines.flow.Flow
import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.models.field.FieldDto

interface PostFieldUseCase {
    fun execute(data : FieldDto, cachePolicy : CachePolicy) : Flow<Result>
}