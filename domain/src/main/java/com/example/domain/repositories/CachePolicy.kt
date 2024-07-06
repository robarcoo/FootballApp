package com.example.domain.repositories

data class CachePolicy(
    val type: Type? = Type.NEVER,
    val expires: Long = 0
) {
    enum class Type {
        NEVER,
        ALWAYS,
        REFRESH,
        CLEAR,
    }
}