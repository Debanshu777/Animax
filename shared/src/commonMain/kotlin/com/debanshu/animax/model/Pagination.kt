package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    @SerialName("current_page")
    val currentPage: Int = 0, // 1
    @SerialName("has_next_page")
    val hasNextPage: Boolean = false, // true
    @SerialName("items")
    val items: Items = Items(),
    @SerialName("last_visible_page")
    val lastVisiblePage: Int = 0 // 883
)