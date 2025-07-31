package com.example.ui.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ui.utils.Constants.APP_TAG
import com.example.ui.utils.UserPreferences

class UserViewModel : ViewModel() {

    private val _listUserName = MutableLiveData<List<String>>(mutableListOf())
    val listUserName: LiveData<List<String>> = _listUserName

    fun addUserName(name: String) {
        val currentList = _listUserName.value.orEmpty().toMutableList()
        currentList.add(name)
        _listUserName.value = currentList

        Log.i(APP_TAG, "Lista atualizada: $currentList")
    }

    fun saveAllUserNames() {
        Log.i(APP_TAG," VM Salvando lista de nomes...")
        UserPreferences.saveAllUserNames(_listUserName.value.orEmpty())
    }

    fun loadAllUserNames() {
        Log.i(APP_TAG," VM Recuperando lista de nomes...")
        _listUserName.value = UserPreferences.loadAllUserNames()
    }
}