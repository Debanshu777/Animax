package com.debanshu.animax.data.domain

import comdebanshuanimax.AnimeEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class LocalAnimeEntity(
    val id: Long?,
    val title: String,
    val imageUrl: String,
    val created: LocalDateTime
)

fun AnimeEntity.toLocalAnimeEntity(): LocalAnimeEntity {
    return LocalAnimeEntity(
        id = id,
        title = name,
        imageUrl = imageUrl,
        created = Instant.fromEpochMilliseconds(created)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}


