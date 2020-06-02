package com.hari.covid_19app

import com.hari.covid_19app.di.AppComponent
import com.hari.covid_19app.di.AppComponentHolder
import com.hari.covid_19app.di.createAppComponent
import com.hari.covid_19app.di.initializer.AppInitializers
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class CovidApp : DaggerApplication(), AppComponentHolder {

    override val appComponent: AppComponent by lazy {
        createAppComponent()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.initialize(this)
    }

}