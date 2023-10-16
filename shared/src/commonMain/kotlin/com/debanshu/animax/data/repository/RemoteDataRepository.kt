package com.debanshu.animax.data.repository

import com.debanshu.animax.data.model.TopAnimeResponse
import com.debanshu.animax.data.networkClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

internal class RemoteDataRepository {
    suspend fun getTopAnimeList(): TopAnimeResponse = networkClient.get {
        url("https://api.jikan.moe/v4/top/anime")
    }.body()
}