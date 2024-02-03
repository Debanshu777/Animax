package com.debanshu.animax.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.debanshu.animax.AppDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
       return NativeSqliteDriver(AppDatabase.Schema,"anime.db")
    }
}