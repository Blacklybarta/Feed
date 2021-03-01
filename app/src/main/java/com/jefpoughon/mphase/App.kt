package com.jefpoughon.mphase

import android.app.Application
import com.jefpoughon.mphase.di.appModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi() {
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}
