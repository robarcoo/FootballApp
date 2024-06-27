package com.example.data.repository

import com.example.domain.repositories.CacheEntry
import com.example.domain.repositories.CachePolicy
import com.example.domain.repositories.CachePolicyRepository
import com.example.domain.models.CommonAnswer
import com.example.domain.models.DataAnswer
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
    private fun remoteCall(response: HttpResponse) = flow {
            when (response.status) {
                HttpStatusCode.OK -> {
                    try {
                        emit(Result.Success(value = response.body<DataAnswer<FieldClass>>()))
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

    private val REFRESH_TIME : Long = 300_000

    private fun isExpired() : Boolean {
        return System.currentTimeMillis() - localDataSource.getLastTimeRefreshed() > REFRESH_TIME
    }

    override fun fetch(id : Int, cachePolicy: CachePolicy): Flow<Result> {
        return flow {
            when (cachePolicy.type) {
                CachePolicy.Type.NEVER -> {
                    val response = remoteDataSource.fetch(id = id)
                    try {
                        remoteCall(response).collect {
                            result -> emit(result)
                        }
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.ALWAYS -> {
                    if (localDataSource.get(id)?.value == null || isExpired()) {
                        fetchAndCache(id).collect { result ->
                            emit(result)
                        }
                    } else {
                        emit(Result.Success(DataAnswer(
                            data = listOf(localDataSource.get(id)))))
                    }
                }
                CachePolicy.Type.CLEAR -> {
                    if (localDataSource.get(id)?.value == null) {
                        val response = remoteDataSource.fetch(id = id)
                        try {
                            remoteCall(response).collect {
                                    result -> emit(result)
                            }
                        } catch (e: Exception) {
                            emit(Result.Error(value = e))
                        }
                    } else {
                        emit(Result.Success(DataAnswer(
                            data = listOf(localDataSource.get(id)))))
                        localDataSource.remove(id)
                        }
                }
                CachePolicy.Type.REFRESH ->
                    fetchAndCache(id)
                null -> emit(Result.Error(value = Exception("error")))
            }
        }

    }

    private fun fetchAndCache(id : Int): Flow<Result> {
        return flow {
            val response = remoteDataSource.fetch(id = id)
            try {
                remoteCall(response = response).collect {result ->
                    when (result) {
                        is Result.Success<*> -> {
                            val field = response.body<DataAnswer<FieldClass>>().data
                            localDataSource.set(CacheEntry(field.first().id.toInt(), field.first()))
                        }
                        else -> {
                            emit(Result.Error(value = Exception("error")))
                        }
                    }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    private fun putAndCache(id : Int, data : FieldClass) : Flow<Result> {
        return flow {
            val response = remoteDataSource.put(id = id, data = data)
            try {
                remoteCall(response = response).collect { result ->
                    when (result) {
                        is Result.Success<*> -> {
                            emit(result)
                            val field = response.body<DataAnswer<FieldClass>>().data
                            localDataSource.set(CacheEntry(field.first().id.toInt(), field.first()))
                        }
                        else -> {
                            emit(Result.Error(value = Exception("error")))
                        }
                    }
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
                        remoteCall(response).collect { result ->
                            emit(result)
                        }
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.ALWAYS -> {
                    if (localDataSource.getAll().isEmpty() ||
                        (System.currentTimeMillis() - localDataSource.getLastTimeRefreshed() > REFRESH_TIME)) {
                        fetchAllAndCache().collect { result ->
                            emit(result)
                        }
                    } else {
                        emit(Result.Success(DataAnswer(
                            data = localDataSource.getAll().map {
                                it.value
                            })))
                    }
                }
                CachePolicy.Type.CLEAR -> {
                    if (localDataSource.getAll().isEmpty() ||
                        (System.currentTimeMillis() - localDataSource.getLastTimeRefreshed() > REFRESH_TIME)) {
                        val response = remoteDataSource.fetchAll()
                        try {
                            remoteCall(response).collect { result ->
                                emit(result)
                            }
                        } catch (e: Exception) {
                            emit(Result.Error(value = e))
                        }
                    } else {
                        emit(Result.Success(DataAnswer(
                            data = localDataSource.getAll().map {
                                it.value
                            })))
                        localDataSource.clear()
                    }
                }
                CachePolicy.Type.REFRESH ->
                    fetchAllAndCache()
                else -> emit(Result.Error(value = Exception("error")))
            }
        }
    }

    private fun fetchAllAndCache(): Flow<Result> {
        return flow {
            val response = remoteDataSource.fetchAll()
            try {
                remoteCall(response = response).collect { result ->
                    when (result) {
                        is Result.Success<*> -> {
                            emit(result)
                            localDataSource.setAll(response.body<DataAnswer<FieldClass>>().data.map {
                                     CacheEntry(it.id.toInt(), it)
                            })
                        }
                        else -> {
                            emit(Result.Error(value = Exception("error")))
                        }
                    }
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
                        remoteCall(response).collect {result ->
                            emit(result)
                        }
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
                        remoteCall(response).collect {result ->
                            emit(result)
                        }
                        localDataSource.remove(id)
                    } catch (e: Exception) {
                        emit(Result.Error(value = e))
                    }
                }
                CachePolicy.Type.REFRESH ->
                    putAndCache(id, data)

                null -> emit(Result.Error(value = Exception("error")))
            }
        }
    }

    private suspend fun postAndCache(id : Int, data : FieldClass) : Flow<Result> {
        return flow {
            val response = remoteDataSource.post(id = id, data = data)
            try {
                remoteCall(response = response).collect {result ->
                    when (result) {
                        is Result.Success<*> -> {
                            val field = response.body<DataAnswer<FieldClass>>().data
                            localDataSource.set(CacheEntry(field.first().id.toInt(), field.first()))
                        }
                        else -> {
                            emit(Result.Error(value = Exception("error")))
                        }
                    }
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
                remoteCall(response = response)
                localDataSource.remove(id)
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }
        }