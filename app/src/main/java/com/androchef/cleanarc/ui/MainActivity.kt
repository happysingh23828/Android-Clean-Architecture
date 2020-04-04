package com.androchef.cleanarc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androchef.cleanarc.MainApplication
import com.androchef.cleanarc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.appComponent().inject(this)
        setContentView(R.layout.activity_main)
    }
}
