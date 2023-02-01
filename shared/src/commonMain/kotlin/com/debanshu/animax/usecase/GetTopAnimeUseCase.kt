package com.debanshu.animax.usecase

import com.debanshu.animax.model.TopAnimeResponse
import com.debanshu.animax.networkClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class GetTopAnimeUseCase : BaseUseCase<Unit, TopAnimeResponse>() {
    override suspend fun execute(request: Unit): TopAnimeResponse {
        val response= networkClient.get("https://api.jikan.moe/v4/top/anime")
        return response.body()
    }
}