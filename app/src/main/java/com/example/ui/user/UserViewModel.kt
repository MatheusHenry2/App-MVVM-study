package com.example.ui.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ui.utils.Constants.APP_TAG
import com.example.ui.utils.UserPreferences

class UserViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    fun setUsername(username: String) {
        Log.i(APP_TAG, "alterando o live data do username")
        _username.value = username
    }

    fun saveUsername() {
        UserPreferences.saveUsername(_username.value.toString())
    }

    fun loadUsername(){
        _username.value = UserPreferences.getUsername()
    }

}