package com.example.domain.usecases.field.impl

import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PostFieldUseCase
import kotlinx.coroutines.flow.Flow

class PostFieldUseCaseImpl(private val repository : CachePolicyRepository<FieldClass>) :
    PostFieldUseCase {

    override fun execute(id: Int, data : FieldClass, cachePolicy: CachePolicy): Flow<Result> {
        return repository.post(id, data, cachePolicy)
    }
}