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

abstract class CachePolicyRepository<T>(
    private val localDataSource: LocalDataSource<String, CacheEntry<T>>,
    private val remoteDataSource: RemoteDataSource<T>
) {
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


    fun fetch(id : Int, cachePolicy: CachePolicy = CachePolicy()): Flow<Result> {
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

    private suspend fun putAndCache(id : Int, data : T) : Flow<Result> {
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

    fun put(id: Int, data: T, cachePolicy: CachePolicy): Flow<Result> {
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

    fun post(id : Int, data: T, cachePolicy: CachePolicy): Flow<Result>{
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

    private suspend fun postAndCache(id : Int, data : T) : Flow<Result> {
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


    fun delete(id : Int) : Flow<Result> {
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

    fun getAll(cachePolicy: CachePolicy) : Flow<Result> {
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
                    localDataSource.setAll(response.body<List<T>>().map { CacheEntry(
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
}

data class CacheEntry<T>(
    val key: Int,
    val value: HttpResponse,
    val createdAt: Long = System.currentTimeMillis()
)

