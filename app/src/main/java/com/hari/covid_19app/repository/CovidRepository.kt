package com.hari.covid_19app.repository

import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.model.LoadState
import com.hari.covid_19app.model.Question
import kotlinx.coroutines.flow.Flow

interface CovidRepository {
    fun getTotalCaseInIndia(): Flow<State>
    fun getGlobalState(): Flow<GlobalState>
    fun getAllStates(): Flow<List<State>>

    fun getPopularQuestions(): Flow<LoadState<List<Question>>>

    suspend fun refreshData()
    suspend fun refreshGlobalData()
    suspend fun refreshDataOfIndia()
}