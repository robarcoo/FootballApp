package com.example.domain.usecases.field.impl

import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import kotlinx.coroutines.flow.Flow


class GetFieldUseCaseImpl(private val repository : CachePolicyRepository<FieldClass>) :
    GetFieldUseCase {

    override fun execute(id: Int, cachePolicy: CachePolicy): Flow<Result> {
        return repository.fetch(id, cachePolicy)
    }
}