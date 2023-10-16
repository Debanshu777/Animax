package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Producer(
    @SerialName("mal_id")
    val malId: Int = 0, // 16
    @SerialName("name")
    val name: String = "", // TV Tokyo
    @SerialName("type")
    val type: String = "", // anime
    @SerialName("url")
    val url: String = "" // https://myanimelist.net/anime/producer/16/TV_Tokyo
)