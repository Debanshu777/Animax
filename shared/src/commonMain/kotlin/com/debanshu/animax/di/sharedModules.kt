package com.debanshu.animax.di

import app.cash.sqldelight.db.SqlDriver
import com.debanshu.animax.AppDatabase
import com.debanshu.animax.data.DatabaseDriverFactory
import com.debanshu.animax.data.repository.LocalDataRepository
import com.debanshu.animax.data.repository.RemoteDataRepository
import com.debanshu.animax.data.usecase.AddLocalAnimeUseCase
import com.debanshu.animax.data.usecase.DeleteLocalAnimeByIdUseCase
import com.debanshu.animax.data.usecase.GetLocalAnimeUseCase
import com.debanshu.animax.data.usecase.GetTopAnimeUseCase
import com.debanshu.animax.utils.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    single { RemoteDataRepository() }
    factory { GetTopAnimeUseCase() }
    factory { GetLocalAnimeUseCase() }
    factory { AddLocalAnimeUseCase() }
    factory { DeleteLocalAnimeByIdUseCase() }
    single { AppDatabase((get() as DatabaseDriverFactory).createDriver()) }
    single { LocalDataRepository(get()) }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val sharedModules = listOf(
    dataModule, utilityModule, getViewModelByPlatform(), getDataDriverFactory()
)

fun getSharedModules() = sharedModules