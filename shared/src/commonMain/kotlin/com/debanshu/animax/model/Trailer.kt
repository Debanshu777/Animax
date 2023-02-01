package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trailer(
    @SerialName("embed_url")
    val embedUrl: String? = "", // https://www.youtube.com/embed/e8YBesRKq_U?enablejsapi=1&wmode=opaque&autoplay=1
    @SerialName("images")
    val images: ImagesX = ImagesX(),
    @SerialName("url")
    val url: String? = "", // https://www.youtube.com/watch?v=e8YBesRKq_U
    @SerialName("youtube_id")
    val youtubeId: String? = "" // e8YBesRKq_U
)