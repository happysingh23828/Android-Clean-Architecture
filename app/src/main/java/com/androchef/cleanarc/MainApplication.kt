package com.androchef.cleanarc

import android.app.Application
import com.androchef.cleanarc.injection.AppComponent
import com.androchef.cleanarc.injection.DaggerAppComponent
import com.facebook.stetho.Stetho

class MainApplication : Application() {

    init {
        instance = this
    }

    var appComponent: AppComponent =
        DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        setDebugLogging()
    }

    private fun setDebugLogging() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    companion object {
        var instance: MainApplication? = null
        fun appComponent(): AppComponent {
            return instance!!.appComponent
        }
    }
}
