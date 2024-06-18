package com.example.data.services

import com.example.data.dto.FieldDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

interface RemoteDataSource<T> {
    suspend fun fetch(url: String): T
    suspend fun fetchAll() : T
    suspend fun put(url: String, data: T): T
    suspend fun post(url: String, data: T): T
    suspend fun delete(url: String): Boolean
}


class FieldService(private val client: HttpClient) : RemoteDataSource<FieldDto> {

    companion object {
        private const val END_POINT = "https://requestdesign.github.io/Footbool/"
    }

    override suspend fun fetch(url: String): FieldDto {
        return client.get("$END_POINT$url").body()
    }

    override suspend fun fetchAll(): FieldDto {
        return Json.decodeFromString<FieldDto>(client.get("https://football.requestbitrix.ru/api/v1/fields/getFields/").body())
    }

    override suspend fun put(url: String, data: FieldDto): FieldDto {
        return client.put("$END_POINT$url") {
            setBody(data)
        }.body()
    }

    override suspend fun post(url: String, data: FieldDto): FieldDto {
        return client.post("$END_POINT$url") {
            setBody(data)
        }.body()
    }

    override suspend fun delete(url: String): Boolean {
        return client.delete("$END_POINT$url").status == HttpStatusCode.OK
    }
}