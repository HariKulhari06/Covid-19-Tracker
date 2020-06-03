package com.hari.covid_19app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.model.AppError
import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.utils.ext.combine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val covidRepository: CovidRepository
) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) { covidRepository.refreshData() }
    }

    data class UiModel(
        val isloading: Boolean,
        val appError: AppError?,
        val totalCaseInIndia: State?,
        val globalState: GlobalState?
    ) {
        companion object {
            val EMPTY = UiModel(
                false,
                null,
                null,
                null
            )
        }
    }

    private val totalCaseOfIndia = covidRepository.getTotalCaseInIndia().asLiveData()
    private val globalState = covidRepository.getGlobalState().asLiveData()


    val ui: LiveData<UiModel> = combine(
        initialValue = UiModel.EMPTY,
        liveData1 = totalCaseOfIndia,
        liveData2 = globalState
    ) { _, totalCaseInIndia, globalState ->

        UiModel(
            false,
            appError = null,
            totalCaseInIndia = totalCaseInIndia,
            globalState = globalState
        )
    }
}