package com.example.movielist.presentation

import android.app.Application
import timber.log.Timber

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.Forest.plant(Timber.DebugTree()) // 🌲 Inisialisasi Timber
    }
}