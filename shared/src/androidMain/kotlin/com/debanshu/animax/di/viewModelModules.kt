package com.debanshu.animax.di

import com.debanshu.animax.data.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    viewModel {
        AppViewModel(get())
    }
}
