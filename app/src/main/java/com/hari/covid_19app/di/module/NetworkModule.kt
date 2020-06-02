package com.hari.covid_19app.di.module

import com.hari.covid_19app.api.CovidApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideCovidApiService(): CovidApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CovidApiService::class.java)
    }
}