package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldDto (
    @SerialName("UF_NAME")
    val ufName: String,

    @SerialName("UF_TOWN")
    val ufTown: Int,

    @SerialName("UF_ADDRESS")
    val ufAddress: String,

    @SerialName("UF_OPENING")
    val ufOpening: String,

    @SerialName("UF_CLOSING")
    val ufClosing: String,

    @SerialName("UF_PHONE")
    val ufPhone: String,

    @SerialName("UF_NEAR_METRO")
    val ufNearMetro: Int?,

    @SerialName("UF_SITE")
    val ufSite: String,

    @SerialName("UF_DESCRIPTION")
    val ufDescription: String,

    @SerialName("UF_PLAYER_CAPACITY")
    val ufPlayerCapacity: Long,

    @SerialName("UF_LENGTH")
    val ufLength: Int?,

    @SerialName("UF_WIDTH")
    val ufWidth: Int?,

    @SerialName("UF_AREA_TYPE")
    val ufAreaType: Int,

    @SerialName("UF_LIGHTING")
    val ufLighting: Int,

    @SerialName("UF_SHOWER")
    val ufShower: Boolean?,

    @SerialName("UF_IMAGES")
    val ufImages: List<String>,

    @SerialName("UF_COVER")
    val ufCover: Int,

    @SerialName("UF_DRESSING_ROOMS")
    val ufDressingRooms: Int,

    @SerialName("UF_STANDS")
    val ufStands: Int?,
)