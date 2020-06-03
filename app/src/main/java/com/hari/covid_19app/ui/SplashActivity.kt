package com.hari.covid_19app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

class SplashActivity : AppCompatActivity() {

    init {
        lifecycleScope.launchWhenResumed {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}