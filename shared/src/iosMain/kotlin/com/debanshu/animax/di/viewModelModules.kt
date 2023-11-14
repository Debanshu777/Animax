package com.debanshu.animax.di

import com.debanshu.animax.data.AppViewModel
import org.koin.dsl.module
actual fun getViewModelByPlatform() = module {
    single {
        AppViewModel(get())
    }
}