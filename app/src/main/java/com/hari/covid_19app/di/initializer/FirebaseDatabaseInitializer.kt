package com.hari.covid_19app.di.initializer

import android.app.Application
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hari.covid_19app.di.appinitializer.AppInitializer
import javax.inject.Inject

class FirebaseDatabaseInitializer @Inject constructor() :
    AppInitializer {
    override fun initialize(application: Application) {
        val database = Firebase.database
        database.setPersistenceEnabled(true)
    }
}
