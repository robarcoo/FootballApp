package com.example.domain.models.datasource

import io.ktor.client.statement.HttpResponse

interface RemoteDataSource<T> {
    suspend fun fetch(id : Int): HttpResponse
    suspend fun fetchAll() : HttpResponse
    suspend fun put(id: Int, data: T): HttpResponse
    suspend fun post(id: Int, data: T): HttpResponse
    suspend fun delete(id : Int): HttpResponse
}

