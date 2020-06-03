package com.hari.covid_19app.di.module

import com.hari.covid_19app.di.PageScope
import com.hari.covid_19app.ui.di.AssistedInjectModule
import com.hari.covid_19app.ui.home.HomeFragment
import com.hari.covid_19app.ui.preventions.PreventionsFragment
import com.hari.covid_19app.ui.questions.PopularQuestionFragment
import com.hari.covid_19app.ui.statistics.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributeStatisticsFragment(): StatisticsFragment

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributePopularQuestionFragment(): PopularQuestionFragment

    @PageScope
    @ContributesAndroidInjector(modules = [AssistedInjectModule::class])
    abstract fun contributePopularPreventionsFragment(): PreventionsFragment
}