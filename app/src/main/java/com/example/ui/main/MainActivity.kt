package com.example.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.study2.R
import com.example.ui.utils.Constants.APP_TAG


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(APP_TAG, "onCreate chamado")
        setContentView(R.layout.activity_main)
    }

}