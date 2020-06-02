package com.hari.covid_19app.repository

import android.util.Log
import com.hari.covid_19app.api.CovidApiService
import com.hari.covid_19app.db.CovidDatabase
import com.hari.covid_19app.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CovidRepositoryImp @Inject constructor(
    private val covidApiService: CovidApiService,
    private val covidDatabase: CovidDatabase
) : CovidRepository {
    override suspend fun testLog() {
        Log.e("testLog", "Textingosjg klsgj sglks g")
        covidDatabase.insert(User())
    }
}