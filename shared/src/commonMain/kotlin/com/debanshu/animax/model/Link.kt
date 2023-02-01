package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    @SerialName("active")
    val active: Boolean = false, // false
    @SerialName("label")
    val label: String = "", // pagination.previous
    @SerialName("url")
    val url: String? = null // http://api.jikan.moe/v4/top/anime?=1
)