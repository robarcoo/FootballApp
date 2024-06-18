package com.example.data.cache

data class CachePolicy(
    val type: Type? = Type.ALWAYS,
    val expires: Long = 0
) {
    enum class Type {
        NEVER,
        ALWAYS,
        REFRESH,
        CLEAR,
        EXPIRES
    }
}