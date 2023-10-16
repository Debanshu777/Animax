package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    @SerialName("mal_id")
    val malId: Int = 0, // 1
    @SerialName("name")
    val name: String = "", // Action
    @SerialName("type")
    val type: String = "", // anime
    @SerialName("url")
    val url: String = "" // https://myanimelist.net/anime/genre/1/Action
)