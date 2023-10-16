package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Broadcast(
    @SerialName("day")
    val day: String? = null, // Tuesdays
    @SerialName("string")
    val string: String? = null, // Tuesdays at 00:00 (JST)
    @SerialName("time")
    val time: String? = null, // 00:00
    @SerialName("timezone")
    val timezone: String? = null // Asia/Tokyo
)