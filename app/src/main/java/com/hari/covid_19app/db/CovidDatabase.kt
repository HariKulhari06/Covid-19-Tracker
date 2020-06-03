package com.hari.covid_19app.db

import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State
import kotlinx.coroutines.flow.Flow

interface CovidDatabase {
    fun getTotalCaseInIndia(): Flow<State>
    fun getAllStates(): Flow<List<State>>
    suspend fun insertStateWiseData(states: List<State>)
    suspend fun insertGlobalStateData(data: GlobalState)
    fun getGlobalState(): Flow<GlobalState>

}