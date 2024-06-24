package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AreaTypeClass (
    @SerialName("ID")
    val id: Long,

    @SerialName("VALUE")
    val value: String
)