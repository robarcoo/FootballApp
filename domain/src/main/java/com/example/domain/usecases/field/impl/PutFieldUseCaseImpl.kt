package com.example.domain.usecases.field.impl

import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PutFieldUseCase
import kotlinx.coroutines.flow.Flow

class PutFieldUseCaseImpl(private val repository : CachePolicyRepository<FieldClass>) :
    PutFieldUseCase {

    override fun execute(id: Int, data : FieldClass, cachePolicy: CachePolicy): Flow<Result> {
        return repository.put(id, data, cachePolicy)
    }
}