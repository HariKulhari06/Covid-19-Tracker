package com.hari.covid_19app.firebaseDatabase

import com.hari.covid_19app.model.LoadState
import com.hari.covid_19app.model.Prevention
import com.hari.covid_19app.model.Question
import kotlinx.coroutines.flow.Flow

interface FirebaseDatabase {
    fun getPopularQuestions(): Flow<LoadState<List<Question>>>
    fun getPreventions(): Flow<LoadState<List<Prevention>>>
}