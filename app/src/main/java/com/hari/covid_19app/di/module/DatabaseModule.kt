package com.hari.covid_19app.di.module

import android.content.Context
import androidx.room.Room
import com.hari.covid_19app.db.CacheDatabase
import com.hari.covid_19app.db.CovidDatabase
import com.hari.covid_19app.db.RoomDatabase
import com.hari.covid_19app.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun cacheDatabase(context: Context): CacheDatabase {
        return Room
            .databaseBuilder(context, CacheDatabase::class.java, "covid.db")
            .build()
    }

    @Provides
    fun provideUserDao(database: CacheDatabase): UserDao = database.userDao()

    @Provides
    fun provideCovidDatabaes(impl: RoomDatabase): CovidDatabase = impl
}