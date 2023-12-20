package com.debanshu.animax.data.usecase

import com.debanshu.animax.data.repository.LocalDataRepository
import com.debanshu.animax.utils.Dispatcher
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeleteLocalAnimeByIdUseCase : KoinComponent {
    private val localDataRepository: LocalDataRepository by inject()
    private val dispatcher: Dispatcher by inject()
    suspend fun execute(id: Long) = withContext(dispatcher.io) {
        localDataRepository.deleteAnimeById(id)
    }
}