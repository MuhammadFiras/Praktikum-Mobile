package com.example.movielistxml

import android.app.Application
import timber.log.Timber

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.i("Timber initialized in MovieApp")
        }
    }
}
