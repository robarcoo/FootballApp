package com.example.domain.repositories

import com.example.domain.models.CommonAnswer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.domain.models.Result
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.datasource.RemoteDataSource
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerializationException

interface CachePolicyRepository<T> {

    fun fetch(id : Int, cachePolicy: CachePolicy = CachePolicy()): Flow<Result>

    fun put(id: Int, data: T, cachePolicy: CachePolicy): Flow<Result>

    fun post(id : Int, data: T, cachePolicy: CachePolicy): Flow<Result>

    fun delete(id : Int) : Flow<Result>

    fun getAll(cachePolicy: CachePolicy) : Flow<Result>


}

data class CacheEntry<T>(
    val key: Int,
    val value: HttpResponse,
    val createdAt: Long = System.currentTimeMillis()
)

