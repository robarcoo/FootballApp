package com.example.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FieldDto(
    val id : Int,
    val created : String,
    val status : String,
    val name : String,
    val cityId : Int,
    val openingTime : String,
    val closingTime : String,
    val phone : String,
    val nearMetro: Int?,
    val site : String,
    val description : String,
    val playerCapacity : Int,
    val fieldLength : Int?,
    val fieldWidth : Int?,
    val areaTypeId : Int,
    val lightningId : Int,
    val shower : Boolean?,
    val images : List<String>,
    val coverId : Int,
    val dressingRooms : Int,
    val stands : Int?




)