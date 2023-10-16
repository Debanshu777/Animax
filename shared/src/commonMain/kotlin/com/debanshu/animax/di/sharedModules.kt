package com.debanshu.animax.di

import com.debanshu.animax.data.repository.RemoteDataRepository
import com.debanshu.animax.data.usecase.GetTopAnimeUseCase
import com.debanshu.animax.utils.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    single { RemoteDataRepository() }
    factory { GetTopAnimeUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val sharedModules = listOf(dataModule, utilityModule)

fun getSharedModules() = sharedModules