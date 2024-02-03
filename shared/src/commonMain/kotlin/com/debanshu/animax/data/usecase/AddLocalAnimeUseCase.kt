package com.debanshu.animax.data.usecase

import com.debanshu.animax.data.domain.DateTimeUtil
import com.debanshu.animax.data.domain.LocalAnimeEntity
import com.debanshu.animax.data.repository.LocalDataRepository
import com.debanshu.animax.utils.Dispatcher
import kotlinx.coroutines.withContext
import kotlinx.datetime.LocalDateTime
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.random.Random

class AddLocalAnimeUseCase : KoinComponent {
    private val localDataRepository: LocalDataRepository by inject()
    private val dispatcher: Dispatcher by inject()
    suspend fun execute(id: Long, title: String, imageUrl: String) = withContext(dispatcher.io) {
        localDataRepository.insertAnime(LocalAnimeEntity(id, title, imageUrl, DateTimeUtil.now()))
    }
}