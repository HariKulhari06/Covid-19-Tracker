package com.hari.covid_19app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hari.covid_19app.repository.CovidRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val covidRepository: CovidRepository
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) { covidRepository.refreshData() }
    }

    val totalCaseOfIndia = covidRepository.getTotalCaseInIndia().asLiveData()
}