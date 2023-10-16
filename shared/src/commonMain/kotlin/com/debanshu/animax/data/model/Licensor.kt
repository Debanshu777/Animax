package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Licensor(
    @SerialName("mal_id")
    val malId: Int = 0, // 119
    @SerialName("name")
    val name: String = "", // VIZ Media
    @SerialName("type")
    val type: String = "", // anime
    @SerialName("url")
    val url: String = "" // https://myanimelist.net/anime/producer/119/VIZ_Media
)