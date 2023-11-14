package com.debanshu.animax.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Items(
    @SerialName("count")
    val count: Int = 0, // 25
    @SerialName("per_page")
    val perPage: Int = 0, // 25
    @SerialName("total")
    val total: Int = 0 // 22052
)