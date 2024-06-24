package com.example.data.repository

import com.example.domain.repositories.CacheEntry
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.data.dto.FieldDto
import com.example.domain.models.Result
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class FieldRepository (private val fieldLocalDataSource : LocalDataSource<String, CacheEntry<FieldDto>>,
                       private val fieldRemoteDataSource : RemoteDataSource<FieldDto>
) :
        CachePolicyRepository<FieldDto>(
            localDataSource = fieldLocalDataSource,
            remoteDataSource = fieldRemoteDataSource
        ) {


    suspend fun getField(id : Int, cachePolicy: CachePolicy): Flow<Result> {
        return fetch(id, cachePolicy)

    }

    suspend fun getAllFields(cachePolicy: CachePolicy) : Flow<Result> {
        return getAll(cachePolicy)
    }

    suspend fun putField(id : Int, data : FieldDto, cachePolicy: CachePolicy) : Flow<Result> {
        return put(id, data, cachePolicy)
    }

    suspend fun postField(id : Int, data : FieldDto, cachePolicy: CachePolicy) : Flow<Result> {
        return post(id, data, cachePolicy)
    }

    suspend fun deleteField(id : Int) : Flow<Result> {
        return delete(id)
    }
        }