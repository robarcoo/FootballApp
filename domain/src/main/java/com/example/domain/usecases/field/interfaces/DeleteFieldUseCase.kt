package com.example.domain.usecases.field.interfaces


import kotlinx.coroutines.flow.Flow
import com.example.domain.models.Result

interface DeleteFieldUseCase {
    fun execute(id : Int) : Flow<Result>
}