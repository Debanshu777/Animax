package com.debanshu.animax.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Aired(
    @SerialName("from")
    val from: String = "", // 2022-10-11T00:00:00+00:00
    @SerialName("prop")
    val prop: Prop = Prop(),
    @SerialName("string")
    val string: String = "", // Oct 11, 2022 to Dec 27, 2022
    @SerialName("to")
    val to: String? = null // 2022-12-27T00:00:00+00:00
)