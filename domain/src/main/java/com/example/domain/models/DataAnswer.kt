package com.example.domain.models

import com.example.domain.models.field.FieldClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataAnswer<T>(
    @SerialName("status")
    val status: Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("time")
    val time: String,
    @SerialName("data")
    val data : List<FieldClass>
)