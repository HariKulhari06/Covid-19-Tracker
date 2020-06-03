package com.hari.covid_19app.di.module

import com.hari.covid_19app.di.appinitializer.AppInitializer
import com.hari.covid_19app.di.initializer.AppInjector
import com.hari.covid_19app.di.initializer.FirebaseDatabaseInitializer
import com.hari.covid_19app.di.initializer.ThemeInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideAppInjector(bind: AppInjector): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideThemeInitializer(bind: ThemeInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideFirebaseInitializer(bind: FirebaseDatabaseInitializer): AppInitializer


}