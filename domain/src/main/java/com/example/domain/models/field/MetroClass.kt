package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetroClass (
    @SerialName("ID")
    val id: Long,

    @SerialName("UF_NAME")
    val ufName: String
)