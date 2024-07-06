package com.example.data.local

import com.example.domain.repositories.CacheEntry
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.field.FieldClass


class LocalFieldSource : LocalDataSource<Int, CacheEntry<FieldClass>> {
    private val fields = mutableMapOf<Int, CacheEntry<FieldClass>>()
    private var lastTimeRefreshed : Long = System.currentTimeMillis()
    override fun getLastTimeRefreshed() : Long {
        return lastTimeRefreshed
    }
    override fun setLastTimeRefreshed(currentTime : Long) {
        lastTimeRefreshed = currentTime
    }
    override fun getAll(): List<CacheEntry<FieldClass>> {
        return fields.values.toList()
    }
    override fun get(id : Int): CacheEntry<FieldClass>? {
        return fields[id]
    }

    override fun set(value: CacheEntry<FieldClass>) {
        setLastTimeRefreshed(System.currentTimeMillis())
        fields[value.key] = value
    }

    override fun setAll(list : List<CacheEntry<FieldClass>>) {
        for (i in list) {
            set(i)
        }
    }

    override fun remove(id : Int) {
        setLastTimeRefreshed(System.currentTimeMillis())
        fields.remove(id)
    }

    override fun clear() {
        setLastTimeRefreshed(System.currentTimeMillis())
        fields.clear()
    }
}