package com.debanshu.animax.android.di

import com.debanshu.animax.android.dummyViewModel
import org.koin.dsl.module

val appModule = module {
    single { dummyViewModel(get()) }
}