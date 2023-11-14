package com.debanshu.animax.utils

import com.debanshu.animax.data.AppViewModel
import com.debanshu.animax.di.getSharedModules
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.component.get
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}

class KoinHelper: KoinComponent {
    fun getAppViewModel() = get<AppViewModel>()
}