package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class To(
    @SerialName("day")
    val day: Int? = null, // 27
    @SerialName("month")
    val month: Int? = null, // 12
    @SerialName("year")
    val year: Int? = null // 2022
)