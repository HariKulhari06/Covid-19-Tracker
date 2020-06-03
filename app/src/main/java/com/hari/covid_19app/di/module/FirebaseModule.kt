package com.hari.covid_19app.di.module

import com.hari.covid_19app.firebaseDatabase.FirebaseDatabase
import com.hari.covid_19app.firebaseDatabase.FirebaseDatabaseImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideDatabase(impl: FirebaseDatabaseImp): FirebaseDatabase {
        return impl
    }

}