package com.debanshu.animax.di

import com.debanshu.animax.data.AppViewModel
import com.debanshu.animax.data.DatabaseDriverFactory
import org.koin.dsl.module
actual fun getViewModelByPlatform() = module {
    single {
        AppViewModel(get(),get(),get(),get())
    }
}

actual fun getDataDriverFactory() = module {
    single { DatabaseDriverFactory() }
}