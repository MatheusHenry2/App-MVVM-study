package com.example.ui.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.ui.utils.Constants.KEY_USERNAME
import com.example.ui.utils.Constants.SHARE_PREF_NAME
import androidx.core.content.edit
import com.example.ui.utils.Constants.APP_TAG

object UserPreferences {

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        Log.i(APP_TAG, "Criando Sharedpreferences")
        sharedPreferences = context.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveUsername(username: String) {
        Log.i(APP_TAG, "Salvando user no Sharedprefenreces")
        sharedPreferences.edit() { putString(KEY_USERNAME, username) }
    }

    fun getUsername(): String? {
        Log.i(APP_TAG, "Recuperando user no sharedPferences")
        return sharedPreferences.getString(KEY_USERNAME, "")
    }
}

