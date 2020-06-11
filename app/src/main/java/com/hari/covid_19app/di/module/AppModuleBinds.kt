package com.hari.covid_19app.di.module

import com.hari.covid_19app.db.CovidDatabase
import com.hari.covid_19app.db.RoomDatabase
import com.hari.covid_19app.di.appinitializer.AppInitializer
import com.hari.covid_19app.di.initializer.FirebaseDatabaseInitializer
import com.hari.covid_19app.di.initializer.ThemeInitializer
import com.hari.covid_19app.firebaseDatabase.FirebaseDatabase
import com.hari.covid_19app.firebaseDatabase.FirebaseDatabaseImp
import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.repository.CovidRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideThemeInitializer(bind: ThemeInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideFirebaseInitializer(bind: FirebaseDatabaseInitializer): AppInitializer

    @Binds
    abstract fun provideCovidDatabaes(impl: RoomDatabase): CovidDatabase

    @Binds
    abstract fun provideFirebaseDatabase(impl: FirebaseDatabaseImp): FirebaseDatabase

    @Binds
    abstract fun provideCovidRepository(impl: CovidRepositoryImp): CovidRepository
}