package ru.spb.viktorii.hotel

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.spb.viktorii.hotel.di.appModule
import ru.spb.viktorii.hotel.di.dataModule
import ru.spb.viktorii.hotel.di.domainModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}