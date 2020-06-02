package com.hari.covid_19app.di.appinitializer

import android.app.Application

interface AppInitializer {
    fun initialize(application: Application)
}
