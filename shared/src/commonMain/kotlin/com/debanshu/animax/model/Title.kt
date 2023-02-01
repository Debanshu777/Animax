package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    @SerialName("title")
    val title: String = "", // Bleach: Sennen Kessen-hen
    @SerialName("type")
    val type: String = "" // Default
)