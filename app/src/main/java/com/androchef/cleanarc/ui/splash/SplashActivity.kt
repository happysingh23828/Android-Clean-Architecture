package com.androchef.cleanarc.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.androchef.cleanarc.R
import com.androchef.cleanarc.ui.movielist.MovieListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            MovieListActivity.start(this)
            finish()
        }, DELAY_IN_IN_TRANSITION)
    }

    companion object {
        private const val DELAY_IN_IN_TRANSITION = 2000L
    }
}
