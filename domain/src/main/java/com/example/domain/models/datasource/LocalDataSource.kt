package com.example.domain.models.datasource

interface LocalDataSource<Key : Any, T> {
    fun getAll() : List<T>
    fun get(id : Int) : T?
    fun set(id : Int, value: T)
    suspend fun setAll(cacheList : List<T>)
    fun remove(id : Int)
    fun clear()
}
