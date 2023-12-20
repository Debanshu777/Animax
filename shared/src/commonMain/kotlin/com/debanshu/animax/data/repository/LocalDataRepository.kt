package com.debanshu.animax.data.repository

import com.debanshu.animax.AppDatabase
import com.debanshu.animax.data.DatabaseDriverFactory
import com.debanshu.animax.data.domain.DateTimeUtil
import com.debanshu.animax.data.domain.LocalAnimeEntity
import com.debanshu.animax.data.domain.toLocalAnimeEntity
import com.debanshu.animax.utils.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class LocalDataRepository(database: AppDatabase) {
    private val queries = database.animeQueries
    fun insertAnime(anime: LocalAnimeEntity) {
        queries.transaction {
            queries.insertAnime(
                anime.id,
                anime.title,
                anime.imageUrl,
                DateTimeUtil.toEpochMillis(anime.created)
            )
        }
    }

    fun getAnimeById(id: Long): LocalAnimeEntity? {
        return queries.getAnimeById(id).executeAsOneOrNull()?.toLocalAnimeEntity()
    }

    fun getAllAnime(): Flow<LocalAnimeEntity> {
        return queries.getAllAnime().executeAsList().asFlow().map {
            it.toLocalAnimeEntity()
        }
    }

    fun deleteAnimeById(id: Long) {
        queries.transaction {
            queries.deleteAnimeById(id)
        }
    }

    fun clearDatabase() {
        queries.transaction {
            queries.removeAllAnime()
        }
    }
}