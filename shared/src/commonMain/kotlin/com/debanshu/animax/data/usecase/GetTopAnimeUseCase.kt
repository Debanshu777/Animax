package com.debanshu.animax.data.usecase

import com.debanshu.animax.data.model.TopAnimeResponse
import com.debanshu.animax.data.networkClient
import com.debanshu.animax.data.repository.RemoteDataRepository
import com.debanshu.animax.utils.Dispatcher
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetTopAnimeUseCase : BaseUseCase<Unit, TopAnimeResponse>(), KoinComponent {
    private val remoteDataRepository: RemoteDataRepository by inject()
    private val dispatcher: Dispatcher by inject()
    override suspend fun execute(request: Unit): TopAnimeResponse = withContext(dispatcher.io) {
        remoteDataRepository.getTopAnimeList()
    }
}