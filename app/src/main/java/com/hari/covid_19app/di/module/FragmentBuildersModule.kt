package com.hari.covid_19app.di.module

import com.hari.covid_19app.ui.home.HomeFragment
import com.hari.covid_19app.ui.home.di.HomeAssistedInjectModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [HomeAssistedInjectModule::class])
    abstract fun contributeHomeFragment(): HomeFragment
}