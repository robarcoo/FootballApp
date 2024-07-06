package com.example.domain.models.field

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldClass(
    @SerialName("ID")
    val id: String,

    @SerialName("UF_CREATED")
    val ufCreated: String,

    @SerialName("UF_STATUS")
    val ufStatus: AreaTypeClass,

    @SerialName("UF_NAME")
    val ufName: String,

    @SerialName("UF_TOWN")
    val ufTown: MetroClass,

    @SerialName("UF_ADDRESS")
    val ufAddress: String,

    @SerialName("UF_OPENING")
    val ufOpening: String,

    @SerialName("UF_CLOSING")
    val ufClosing: String,

    @SerialName("UF_PHONE")
    val ufPhone: String,

    @SerialName("UF_NEAR_METRO")
    val ufNearMetro: MetroClass?,

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
    val ufAreaType: AreaTypeClass,

    @SerialName("UF_LIGHTING")
    val ufLighting: AreaTypeClass,

    @SerialName("UF_SHOWER")
    val ufShower: Boolean?,

    @SerialName("UF_IMAGES")
    val ufImages: List<UfImage>,

    @SerialName("UF_COVER")
    val ufCover: AreaTypeClass,

    @SerialName("UF_DRESSING_ROOMS")
    val ufDressingRooms: AreaTypeClass,

    @SerialName("UF_STANDS")
    val ufStands: Int?,

    @SerialName("UF_USER")
    val ufUser: Long,

    @SerialName("UF_RATING")
    val ufRating: Float,

    @SerialName("UF_TAGS")
    val ufTags: List<UfTag>,

    @SerialName("FAVORITE")
    val favorite: Boolean
)







