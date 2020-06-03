package com.hari.covid_19app.di.module

import com.hari.covid_19app.di.PageScope
import com.hari.covid_19app.ui.home.HomeFragment
import com.hari.covid_19app.ui.home.di.HomeAssistedInjectModule
import com.hari.covid_19app.ui.questions.PopularQuestionFragment
import com.hari.covid_19app.ui.statistics.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @PageScope
    @ContributesAndroidInjector(modules = [HomeAssistedInjectModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @PageScope
    @ContributesAndroidInjector(modules = [HomeAssistedInjectModule::class])
    abstract fun contributeStatisticsFragment(): StatisticsFragment

    @PageScope
    @ContributesAndroidInjector(modules = [HomeAssistedInjectModule::class])
    abstract fun contributePopularQuestionFragment(): PopularQuestionFragment
}