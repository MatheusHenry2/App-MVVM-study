package com.example.ui.main

import android.app.Application
import com.example.ui.utils.UserPreferences

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UserPreferences.init(this)
    }
}