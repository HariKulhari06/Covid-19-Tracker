package com.hari.covid_19app.ui.statistics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hari.covid_19app.repository.CovidRepository

class StatisticsViewModel @ViewModelInject constructor(
    covidRepository: CovidRepository
) : ViewModel() {

    val states = covidRepository.getAllStates().asLiveData()
}