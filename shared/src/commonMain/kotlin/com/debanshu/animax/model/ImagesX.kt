package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesX(
    @SerialName("image_url")
    val imageUrl: String? = null, // https://img.youtube.com/vi/e8YBesRKq_U/default.jpg
    @SerialName("large_image_url")
    val largeImageUrl: String? = null, // https://img.youtube.com/vi/e8YBesRKq_U/hqdefault.jpg
    @SerialName("maximum_image_url")
    val maximumImageUrl: String? = null, // https://img.youtube.com/vi/e8YBesRKq_U/maxresdefault.jpg
    @SerialName("medium_image_url")
    val mediumImageUrl: String? = null, // https://img.youtube.com/vi/e8YBesRKq_U/mqdefault.jpg
    @SerialName("small_image_url")
    val smallImageUrl: String? = null // https://img.youtube.com/vi/e8YBesRKq_U/sddefault.jpg
)