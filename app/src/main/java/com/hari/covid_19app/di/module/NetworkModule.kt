package com.hari.covid_19app.di.module

import com.google.gson.GsonBuilder
import com.hari.covid_19app.BuildConfig
import com.hari.covid_19app.api.CovidApiService
import com.hari.covid_19app.api.VirusTrackerApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideCovidApiService(): CovidApiService {
        val loggingInterceptor = getLoggingInterceptor()
        val client = okHttpClient(loggingInterceptor)
        return Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CovidApiService::class.java)

    }

    @Singleton
    @Provides
    fun provideVirusTrackerApiService(): VirusTrackerApi {
        val loggingInterceptor = getLoggingInterceptor()
        val client = okHttpClient(loggingInterceptor)
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl("https://api.thevirustracker.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(VirusTrackerApi::class.java)

    }

    private fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        return client
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }
}