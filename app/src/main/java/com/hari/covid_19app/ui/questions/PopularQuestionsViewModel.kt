package com.hari.covid_19app.ui.questions

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hari.covid_19app.model.AppError
import com.hari.covid_19app.model.Question
import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.utils.ext.combine
import com.hari.covid_19app.utils.ext.toAppError

class PopularQuestionsViewModel @ViewModelInject constructor(
    private val covidRepository: CovidRepository
) : ViewModel() {
    class UiModel(
        val isLoading: Boolean,
        val appError: AppError?,
        val questions: List<Question>?
    ) {
        companion object {
            val EMPTY = UiModel(
                false,
                null,
                null
            )
        }

    }

    private val questionLoadState = covidRepository.getPopularQuestions().asLiveData()

    val ui: LiveData<UiModel> = combine(
        initialValue = UiModel.EMPTY,
        liveData1 = questionLoadState
    ) { _, questions ->

        UiModel(
            isLoading = questions.isLoading,
            appError = questions.getErrorIfExists().toAppError(),
            questions = questions.getValueOrNull()
        )
    }

}