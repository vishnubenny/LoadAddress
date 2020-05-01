package com.vishnu.loadaddress

import android.app.Application
import com.vishnu.loadaddress.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoadAddressApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoadAddressApp)
            modules(appModule)
        }
    }
}
