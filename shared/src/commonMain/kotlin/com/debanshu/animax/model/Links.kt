package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("first")
    val first: String = "", // http://api.jikan.moe/v4/top/anime?=1
    @SerialName("last")
    val last: String = "", // http://api.jikan.moe/v4/top/anime?=883
    @SerialName("next")
    val next: String = "", // http://api.jikan.moe/v4/top/anime?=2
    @SerialName("prev")
    val prev: String? = null // null
)