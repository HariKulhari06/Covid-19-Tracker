package com.hari.covid_19app.di.initializer

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.hari.covid_19app.di.appinitializer.AppInitializer
import com.hari.covid_19app.utils.pref.ThemePrefs
import javax.inject.Inject

class ThemeInitializer @Inject constructor() :
    AppInitializer {
    override fun initialize(application: Application) {
        AppCompatDelegate.setDefaultNightMode(ThemePrefs(application).getNightMode())
    }
}
