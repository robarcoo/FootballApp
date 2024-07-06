package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UfImage (
    @SerialName("SRC")
    val src: String
)