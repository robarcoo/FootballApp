package com.example.domain.models

import com.example.domain.models.field.FieldClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataAnswer<T>(
    @SerialName("status")
    val status: Boolean = true,
    @SerialName("code")
    val code: String = "200",
    @SerialName("message")
    val message: String = "OK",
    @SerialName("time")
    val time: String = "",
    @SerialName("data")
    val data : List<T>
)

@Serializable
data class PostDataAnswer(
    @SerialName("status")
    val status: Boolean = true,
    @SerialName("code")
    val code: String = "200",
    @SerialName("message")
    val message: String = "OK",
    @SerialName("time")
    val time: String = "",
    @SerialName("data")
    val data : PostAnswerSuccess
)

@Serializable
data class PostAnswerSuccess(
    @SerialName("RESULT")
    val result : String,
    @SerialName("ID")
    val id : Int
)