package com.hari.covid_19app.di.module

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hari.covid_19app.BuildConfig
import com.hari.covid_19app.api.CovidApiService
import com.hari.covid_19app.api.VirusTrackerApi
import com.hari.covid_19app.db.CacheDatabase
import com.hari.covid_19app.db.dao.GlobalStateDao
import com.hari.covid_19app.db.dao.StateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun cacheDatabase(@ApplicationContext context: Context): CacheDatabase {
        return Room
            .databaseBuilder(context, CacheDatabase::class.java, "covid.db")
            .build()
    }

    @Provides
    fun provideStateDao(database: CacheDatabase): StateDao = database.stateDao()

    @Provides
    fun provideGlobalStateDao(database: CacheDatabase): GlobalStateDao = database.globalStateDao()


    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideCovidApiService(gson: Gson, okHttpClient: OkHttpClient): CovidApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(CovidApiService::class.java)

    }

    @Provides
    fun provideVirusTrackerApiService(gson: Gson, okHttpClient: OkHttpClient): VirusTrackerApi {
        return Retrofit.Builder()
            .baseUrl("https://api.thevirustracker.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(VirusTrackerApi::class.java)

    }
}
