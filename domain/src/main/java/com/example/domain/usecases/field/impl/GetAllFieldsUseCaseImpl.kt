package com.example.domain.usecases.field.impl

import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.usecases.field.interfaces.GetAllFieldsUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import kotlinx.coroutines.flow.Flow

class GetAllFieldsUseCaseImpl(private val repository : CachePolicyRepository<FieldClass>) :
    GetAllFieldsUseCase {

    override fun execute(cachePolicy: CachePolicy): Flow<Result> {
        return repository.getAll(cachePolicy)
    }

}