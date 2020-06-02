package com.hari.covid_19app.db

import com.hari.covid_19app.model.User

interface CovidDatabase {
    suspend fun insert(user: User)
}