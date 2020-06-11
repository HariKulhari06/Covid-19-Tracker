package com.hari.covid_19app.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.hari.covid_19app.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    init {
        lifecycleScope.launchWhenResumed {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}