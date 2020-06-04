package com.hari.covid_19app.di

import com.hari.covid_19app.repository.CovidRepository


interface AppComponentHolder {
    val appComponent: AppComponentInterface
}

interface AppComponentInterface {
    fun covidRepository(): CovidRepository
}
