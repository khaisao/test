package com.shoes.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun helloWorld(b: Int, d: Boolean) {


    }

    fun test() {


    }

    fun abc() {
        Log.d("kasjhgk", "abc: ")
    }
}