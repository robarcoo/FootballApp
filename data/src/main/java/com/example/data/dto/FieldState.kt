package com.example.data.dto

import androidx.compose.runtime.mutableStateListOf
import com.example.domain.models.field.AreaTypeClass
import com.example.domain.models.field.FieldClass
import com.example.domain.models.field.MetroClass
import com.example.domain.models.field.UfTag
import com.example.domain.models.field.UfImage

data class FieldState(
    val id: String = "",
    val ufCreated: String = "",
    val ufStatus: AreaTypeClass = AreaTypeClass(0, ""),
    val ufName: String = "",
    val ufTown: MetroClass? = null,
    val ufAddress: String = "",
    val ufOpening: String = "",
    val ufClosing: String = "",
    val ufPhone: String = "",
    val ufNearMetro: MetroClass? = null,
    val ufSite: String = "",
    val ufDescription: String = "",
    val ufPlayerCapacity: Long = 0L,
    val ufLength: Int? = null,
    val ufWidth: Int? = null,
    val ufAreaType: AreaTypeClass = AreaTypeClass(0, ""),
    val ufLighting: AreaTypeClass = AreaTypeClass(0, ""),
    val ufShower: Boolean? = null,
    val ufImages: MutableList<UfImage> = mutableStateListOf(),
    val ufCover: AreaTypeClass = AreaTypeClass(0, ""),
    val ufDressingRooms: AreaTypeClass = AreaTypeClass(0, ""),
    val ufStands: Int? = null,
    val ufUser: Long = 0L,
    val ufRating: Float = 0.0f,
    val ufTags: MutableList<UfTag> = mutableStateListOf(),
    val favorite: Boolean = false,
    var fieldList : MutableList<FieldClass> = mutableStateListOf()
)
