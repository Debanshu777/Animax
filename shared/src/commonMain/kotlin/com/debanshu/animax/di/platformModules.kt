package com.debanshu.animax.di

import org.koin.core.module.Module

internal expect fun getViewModelByPlatform(): Module

internal expect  fun getDataDriverFactory():Module