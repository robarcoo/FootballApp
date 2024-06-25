package com.example.data.local

import com.example.domain.repositories.CacheEntry
import com.example.data.dto.FieldDto
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.field.FieldClass
import io.ktor.client.call.body



class LocalFieldSource : LocalDataSource<Int, CacheEntry<FieldClass>> {
    private val fields = mutableMapOf<Int, CacheEntry<FieldClass>>()

    override fun getAll(): List<CacheEntry<FieldClass>> {
        return fields.values.toList()
    }
    override fun get(id : Int): CacheEntry<FieldClass>? {
        return fields[id]
    }

    override fun set(id : Int, value: CacheEntry<FieldClass>) {
        fields[id] = value
    }

    override suspend fun setAll(cacheList : List<CacheEntry<FieldClass>>) {
        for (i in cacheList) {
            val id = i.value.body<FieldClass>().id.toInt()
            set(id, CacheEntry(id, i.value))
        }
    }

    override fun remove(id : Int) {
        fields.remove(id)
    }

    override fun clear() {
        fields.clear()
    }
}