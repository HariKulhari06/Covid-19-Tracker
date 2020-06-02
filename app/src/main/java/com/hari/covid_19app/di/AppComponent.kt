package com.hari.covid_19app.di

import android.app.Application
import com.hari.covid_19app.CovidApp
import com.hari.covid_19app.di.module.AppModule
import com.hari.covid_19app.di.module.DatabaseModule
import com.hari.covid_19app.di.module.NetworkModule
import com.hari.covid_19app.di.module.RepositoyModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        NetworkModule::class,
        RepositoyModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<CovidApp>, AppComponentInterface {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(app: CovidApp)
}

fun Application.createAppComponent() = DaggerAppComponent.factory().create(this)