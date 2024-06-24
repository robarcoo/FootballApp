package com.example.domain.usecases.field.impl

import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.usecases.field.interfaces.DeleteFieldUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import kotlinx.coroutines.flow.Flow

class DeleteFieldUseCaseImpl(private val repository : CachePolicyRepository<FieldClass>) :
    DeleteFieldUseCase {

    override fun execute(id: Int): Flow<Result> {
        return repository.delete(id)
    }
}