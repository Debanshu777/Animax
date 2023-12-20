package com.debanshu.animax.android

import android.app.Application
import android.content.Context
import com.debanshu.animax.di.getSharedModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AnimaxApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            module{
                single<Context> { this@AnimaxApplication }
                getSharedModules()
            }
        }
    }
}