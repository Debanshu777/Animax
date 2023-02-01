package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Webp(
    @SerialName("image_url")
    val imageUrl: String = "", // https://cdn.myanimelist.net/images/anime/1764/126627.webp
    @SerialName("large_image_url")
    val largeImageUrl: String = "", // https://cdn.myanimelist.net/images/anime/1764/126627l.webp
    @SerialName("small_image_url")
    val smallImageUrl: String = "" // https://cdn.myanimelist.net/images/anime/1764/126627t.webp
)