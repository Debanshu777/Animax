package com.debanshu.animax.data.usecase

import com.debanshu.animax.data.domain.LocalAnimeEntity
import com.debanshu.animax.data.repository.LocalDataRepository
import com.debanshu.animax.utils.Dispatcher
import dev.icerock.moko.mvvm.flow.cFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetLocalAnimeUseCase : KoinComponent {
    private val localDataRepository: LocalDataRepository by inject()
    private val dispatcher: Dispatcher by inject()
    suspend fun execute(): Flow<List<LocalAnimeEntity>> =
        withContext(dispatcher.io) {
            localDataRepository.getAllAnime()
        }
}