package com.example.internsimple

import android.app.Application
import android.content.Context
import com.example.internsimple.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        configureKoin(this)
    }

    private fun configureKoin(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(appModule)
        }
    }
}