package com.hari.covid_19app.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AppModuleBinds::class,
        MainActivityModule::class
    ]
)
class AppModule {
    @Provides
    fun provideAppContext(application: Application): Context {
        return application
    }
}
