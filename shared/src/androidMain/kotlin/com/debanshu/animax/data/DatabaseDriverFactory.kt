package com.debanshu.animax.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.debanshu.animax.AppDatabase

actual class DatabaseDriverFactory(private val context:Context) {
    actual fun createDriver(): SqlDriver {
        return  AndroidSqliteDriver(AppDatabase.Schema,context,"anime.db")
    }
}