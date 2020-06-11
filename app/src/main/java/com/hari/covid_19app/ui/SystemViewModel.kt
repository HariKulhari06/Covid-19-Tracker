package com.hari.covid_19app.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hari.covid_19app.model.AppError
import com.hari.covid_19app.model.NightMode
import com.hari.covid_19app.utils.ext.combine
import com.hari.covid_19app.utils.ext.toNonNullSingleEvent

class SystemViewModel @ViewModelInject constructor() : ViewModel() {
    private val mutableErrorLiveData = MutableLiveData<AppError?>()
    val errorLiveData: LiveData<AppError> get() = mutableErrorLiveData.toNonNullSingleEvent()
    fun onError(error: AppError) {
        mutableErrorLiveData.value = error
    }

    data class UiModel(
        val nightMode: NightMode
    ) {
        companion object {
            val EMPTY = UiModel(NightMode.NO)
        }
    }

    private val nightModeLiveData: MutableLiveData<NightMode> = MutableLiveData(NightMode.NO)

    var uiModel: LiveData<UiModel> = combine(
        initialValue = UiModel.EMPTY,
        liveData1 = nightModeLiveData
    ) { _: UiModel, nightMode: NightMode ->
        UiModel(
            nightMode = nightMode
        )
    }

    fun setNightMode(newValue: NightMode) {
        nightModeLiveData.value = newValue
    }

    fun toggleNightMode() {
        uiModel.value?.nightMode?.let { nightMode ->
            if (nightMode == NightMode.NO) {
                setNightMode(NightMode.YES)
            } else {
                setNightMode(NightMode.NO)
            }
        }
    }

}