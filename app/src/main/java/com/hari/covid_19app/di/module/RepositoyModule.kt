package com.hari.covid_19app.di.module

import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.repository.CovidRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoyModule {
    @Singleton
    @Provides
    fun provideCovidRepository(impl: CovidRepositoryImp): CovidRepository {
        return impl
    }
}