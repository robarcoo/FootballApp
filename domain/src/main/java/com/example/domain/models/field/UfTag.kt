package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UfTag (
    @SerialName("NAME")
    val name: String,

    @SerialName("COUNT")
    val count: Long
)