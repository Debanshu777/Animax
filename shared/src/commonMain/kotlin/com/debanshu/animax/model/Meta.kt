package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("current_page")
    val currentPage: Int = 0, // 1
    @SerialName("from")
    val from: Int = 0, // 1
    @SerialName("last_page")
    val lastPage: Int = 0, // 883
    @SerialName("links")
    val links: List<Link> = listOf(),
    @SerialName("path")
    val path: String = "", // http://api.jikan.moe/v4/top/anime
    @SerialName("per_page")
    val perPage: Int = 0, // 25
    @SerialName("to")
    val to: Int = 0, // 25
    @SerialName("total")
    val total: Int = 0 // 22052
)