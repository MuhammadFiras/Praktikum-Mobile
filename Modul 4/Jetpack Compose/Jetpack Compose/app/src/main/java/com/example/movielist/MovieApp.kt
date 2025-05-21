package com.example.movielist

import android.app.Application
import timber.log.Timber

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree()) // 🌲 Inisialisasi Timber
    }
}
