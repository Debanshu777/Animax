package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopAnimeResponse(
    @SerialName("data")
    val `data`: List<Anime> = listOf(),
    @SerialName("links")
    val links: Links = Links(),
    @SerialName("meta")
    val meta: Meta = Meta(),
    @SerialName("pagination")
    val pagination: Pagination = Pagination()
)