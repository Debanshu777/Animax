package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Demographic(
    @SerialName("mal_id")
    val malId: Int = 0, // 27
    @SerialName("name")
    val name: String = "", // Shounen
    @SerialName("type")
    val type: String = "", // anime
    @SerialName("url")
    val url: String = "" // https://myanimelist.net/anime/genre/27/Shounen
)