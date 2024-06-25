package com.example.data.repository

import com.example.domain.repositories.CacheEntry
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.data.dto.FieldDto
import com.example.domain.models.CommonAnswer
import com.example.domain.models.Result
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.datasource.RemoteDataSource
import com.example.domain.models.field.FieldClass
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

class FieldRepository (private val localDataSource : LocalDataSource<String, CacheEntry<FieldClass>>,
                       private val remoteDataSource : RemoteDataSource<FieldClass>
) :
        CachePolicyRepository<FieldClass> {

    private suspend fun remoteCall(response: HttpResponse): Boolean {
        var isSuccessful = false
        flow {
            when (response.status) {
                HttpStatusCode.OK -> {
                    try {
                        emit(Result.Success(value = response.body<CommonAnswer>()))
                        isSuccessful = true
                    } catch (e: SerializationException) {
                        emit(
                            Result.ErrorNetwork(
                                value = response.body<CommonAnswer>()
                                    .toCommonAnswerUi()
                            )
                        )
                    }
                }

                else -> {
                    emit(Result.Error(value = Exception("error")))
                }
            }
        }
        return isSuccessful
    }

    override fun fetch(id : Int, cachePolicy: CachePolicy): Flow<Result> {
        return flow {
            when (cachePolicy.type) {
                CachePolicy.Type.NEVER -> {
                    val response = remoteDataSource.fetch(id = id)
                    try {
                        remoteCall(response)
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.ALWAYS -> {
                    localDataSource.get(id)?.value ?: fetchAndCache(id)
                }

                CachePolicy.Type.CLEAR -> {
                    localDataSource.get(id)?.value.also {
                        localDataSource.remove(id)
                    }
                }
                CachePolicy.Type.REFRESH ->
                    fetchAndCache(id)

                CachePolicy.Type.EXPIRES -> {
                    localDataSource.get(id)?.let {
                        if ((it.createdAt + cachePolicy.expires) > System.currentTimeMillis()) {
                            it.value
                        } else {
                            fetchAndCache(id)
                        }
                    } ?: fetchAndCache(id)
                }
                null -> emit(Result.Error(value = Exception("error")))
            }
        }

    }

    private suspend fun fetchAndCache(id : Int): Flow<Result> {
        return flow {
            val response = remoteDataSource.fetch(id = id)
            try {
                if (remoteCall(response = response)) {
                    localDataSource.set(id, CacheEntry(key = id, value = response))
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    private suspend fun putAndCache(id : Int, data : FieldClass) : Flow<Result> {
        return flow {
            val response = remoteDataSource.put(id = id, data = data)
            try {
                if (remoteCall(response = response)) {
                    localDataSource.set(id, CacheEntry(key = id, value = response))
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun getAll(cachePolicy: CachePolicy) : Flow<Result> {
        return flow {
            when (cachePolicy.type) {
                CachePolicy.Type.NEVER -> {
                    val response = remoteDataSource.fetchAll()
                    try {
                        remoteCall(response)
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.ALWAYS -> {
                    if (localDataSource.getAll().isEmpty()) {
                        fetchAllAndCache()
                    }
                }

                CachePolicy.Type.CLEAR -> {
                    localDataSource.getAll().also {
                        localDataSource.clear()
                    }
                }

                CachePolicy.Type.REFRESH ->
                    fetchAllAndCache()

                CachePolicy.Type.EXPIRES -> {
                    localDataSource.getAll().let {fields ->
                        for (it in fields) {
                            if ((it.createdAt + cachePolicy.expires) > System.currentTimeMillis()) {
                                it.value
                            } else {
                                fetchAllAndCache()
                            }
                        }
                    }
                }
                null -> emit(Result.Error(value = Exception("error")))
            }
        }
    }

    private suspend fun fetchAllAndCache(): Flow<Result> {
        return flow {
            val response = remoteDataSource.fetchAll()
            try {
                if (remoteCall(response = response)) {
                    localDataSource.setAll(response.body<List<FieldClass>>().map { CacheEntry(
                        it.hashCode(),
                        value = response)
                    },
                    )
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun put(id : Int, data : FieldClass, cachePolicy: CachePolicy) : Flow<Result> {
        return flow {
            when (cachePolicy.type) {
                CachePolicy.Type.NEVER -> {
                    val response = remoteDataSource.put(id = id, data = data)
                    try {
                        remoteCall(response)
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.ALWAYS -> {
                    putAndCache(id, data)
                }

                CachePolicy.Type.CLEAR -> {
                    val response = remoteDataSource.put(id = id, data = data)
                    try {
                        if (remoteCall(response)) {
                            localDataSource.remove(id)
                        }
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }

                CachePolicy.Type.REFRESH ->
                    putAndCache(id, data)

                CachePolicy.Type.EXPIRES -> {
                    localDataSource.get(id)?.let {
                        if ((it.createdAt + cachePolicy.expires) > System.currentTimeMillis()) {
                            val response = remoteDataSource.put(id = id, data = data)
                            try {
                                remoteCall(response)
                            } catch (e: Exception) {
                                emit(Result.Error(value = e))
                            }
                        } else {
                            putAndCache(id, data)
                        }
                    } ?: putAndCache(id, data)
                }
                null -> emit(Result.Error(value = Exception("error")))
            }
        }
    }

    private suspend fun postAndCache(id : Int, data : FieldClass) : Flow<Result> {
        return flow {
            val response = remoteDataSource.post(id = id, data = data)
            try {
                if (remoteCall(response = response)) {
                    localDataSource.set(id, CacheEntry(key = id, value = response))
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }
    override fun post(id : Int, data : FieldClass, cachePolicy: CachePolicy) : Flow<Result> {
        return flow {
            when (cachePolicy.type) {
                CachePolicy.Type.NEVER -> {
                    val response = remoteDataSource.put(id = id, data = data)
                    try {
                        remoteCall(response)
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                else -> postAndCache(id, data)
            }
        }
    }

    override fun delete(id : Int) : Flow<Result> {
        return flow {
            val response = remoteDataSource.delete(id = id)
            try {
                if (remoteCall(response = response)) {
                    localDataSource.remove(id)
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

        }