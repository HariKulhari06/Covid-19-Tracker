package com.hari.covid_19app.ui.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hari.covid_19app.repository.CovidRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    private val covidRepository: CovidRepository
) : ViewModel() {

    val states = covidRepository.getAllStates().asLiveData()
}