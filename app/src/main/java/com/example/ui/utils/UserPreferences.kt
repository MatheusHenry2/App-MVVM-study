package com.example.ui.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.ui.utils.Constants.KEY_USERNAME
import com.example.ui.utils.Constants.SHARE_PREF_NAME
import androidx.core.content.edit
import com.example.ui.utils.Constants.APP_TAG
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object UserPreferences {

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        Log.i(APP_TAG, "Criando Sharedpreferences")
        sharedPreferences = context.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveAllUserNames(usernames: List<String>) {
        Log.i(APP_TAG, "Salvando lista de usuários no SharedPreferences $usernames")
        val usernamesList = Gson().toJson(usernames)
        sharedPreferences.edit() { putString(KEY_USERNAME, usernamesList) }
    }

    fun loadAllUserNames(): List<String> {
        val json = sharedPreferences.getString(KEY_USERNAME, null)
        return if (json != null) {
            val type = object : TypeToken<List<String>>() {}.type
            Gson().fromJson(json, type)
        } else {
            emptyList()
        }
    }
}

