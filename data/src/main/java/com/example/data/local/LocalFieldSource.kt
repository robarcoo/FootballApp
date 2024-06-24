package com.example.data.local

import com.example.domain.repositories.CacheEntry
import com.example.data.dto.FieldDto
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.field.FieldClass
import io.ktor.client.call.body



class LocalFieldSource : LocalDataSource<Int, CacheEntry<FieldDto>> {
    private val fields = mutableMapOf<Int, CacheEntry<FieldDto>>()

    override fun getAll(): List<CacheEntry<FieldDto>> {
        return fields.values.toList()
    }
    override fun get(id : Int): CacheEntry<FieldDto>? {
        return fields[id]
    }

    override fun set(id : Int, value: CacheEntry<FieldDto>) {
        fields[id] = value
    }

    override suspend fun setAll(cacheList : List<CacheEntry<FieldDto>>) {
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