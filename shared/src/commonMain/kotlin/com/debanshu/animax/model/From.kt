package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class From(
    @SerialName("day")
    val day: Int = 0, // 11
    @SerialName("month")
    val month: Int = 0, // 10
    @SerialName("year")
    val year: Int = 0 // 2022
)