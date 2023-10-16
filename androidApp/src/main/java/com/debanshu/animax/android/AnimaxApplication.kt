package com.debanshu.animax.android

import android.app.Application
import com.debanshu.animax.android.di.appModule
import com.debanshu.animax.di.getSharedModules
import org.koin.core.context.startKoin

class AnimaxApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule+ getSharedModules())
        }
    }
}