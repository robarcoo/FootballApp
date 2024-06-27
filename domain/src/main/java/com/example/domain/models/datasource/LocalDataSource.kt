package com.example.domain.models.datasource

import com.example.domain.repositories.CachePolicy

interface LocalDataSource<Key : Any, T> {

    fun getLastTimeRefreshed() : Long
    fun setLastTimeRefreshed(currentTime : Long)
    fun getAll() : List<T>
    fun get(id : Int) : T?
    fun set(value: T)
    fun setAll(list : List<T>)
    fun remove(id : Int)
    fun clear()
}
