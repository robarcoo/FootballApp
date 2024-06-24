package com.example.data.services

import com.example.data.dto.FieldDto
import com.example.domain.models.datasource.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import kotlinx.serialization.json.Json



class FieldService(private val client: HttpClient) : RemoteDataSource<FieldDto> {

    private val ALL_FIELDS = "fields/getFields/"
    private val GET_FIELD = "fields/getField/"
    private val UPDATE_FIELD = "fields/updateField/"
    private val CREATE_FIELD = "fields/createField/"
    private val DELETE_FIELD = "fields/deleteField/"
    
    override suspend fun fetch(id : Int): HttpResponse {
        return client.get("$GET_FIELD$id").body()
    }

    override suspend fun fetchAll(): HttpResponse {
        return client.get(ALL_FIELDS).body()
    }

    override suspend fun put(id: Int, data: FieldDto): HttpResponse {
        return client.put("$UPDATE_FIELD$id")
        {
            contentType(ContentType.Application.Json)
            setBody(data)
        }.body()
    }

    override suspend fun post(id : Int, data: FieldDto): HttpResponse {
        return client.post("$CREATE_FIELD$id") {
            contentType(ContentType.Application.Json)
            setBody(data)
        }.body()
    }

    override suspend fun delete(id : Int): HttpResponse {
        return client.delete("$DELETE_FIELD$id").body()
    }
}