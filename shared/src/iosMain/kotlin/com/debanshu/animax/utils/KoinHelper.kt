package com.debanshu.animax.utils

import com.debanshu.animax.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}