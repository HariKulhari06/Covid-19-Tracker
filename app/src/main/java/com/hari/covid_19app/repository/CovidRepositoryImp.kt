package com.hari.covid_19app.repository

import com.hari.covid_19app.api.CovidApiService
import com.hari.covid_19app.api.VirusTrackerApi
import com.hari.covid_19app.db.CovidDatabase
import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.firebaseDatabase.FirebaseDatabase
import com.hari.covid_19app.mapper.DataApiResponseToStateEntity
import com.hari.covid_19app.mapper.GlobalStateResponseToGlobalState
import com.hari.covid_19app.model.*
import com.hari.covid_19app.utils.ext.executeWithRetry
import com.hari.covid_19app.utils.ext.toResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CovidRepositoryImp @Inject constructor(
    private val covidApiService: CovidApiService,
    private val virusTrackerApi: VirusTrackerApi,
    private val covidDatabase: CovidDatabase,
    private val firebaseDatabase: FirebaseDatabase,
    private val dataApiResponseToStateEntity: DataApiResponseToStateEntity,
    private val globalStateResponseToGlobalState: GlobalStateResponseToGlobalState
) : CovidRepository {

    override fun getTotalCaseInIndia() = covidDatabase.getTotalCaseInIndia()

    override fun getGlobalState(): Flow<GlobalState> = covidDatabase.getGlobalState()

    override fun getAllStates(): Flow<List<State>> = covidDatabase.getAllStates()

    override fun getPopularQuestions(): Flow<LoadState<List<Question>>> =
        firebaseDatabase.getPopularQuestions()

    override fun getPreventions(): Flow<LoadState<List<Prevention>>> =
        firebaseDatabase.getPreventions()

    override suspend fun refreshGlobalData() {
        try {
            when (val result = virusTrackerApi.getGlobalState()
                .executeWithRetry().toResult(globalStateResponseToGlobalState.toLambda())) {
                is Success -> {
                    covidDatabase.insertGlobalStateData(result.data)
                }
                is ErrorResult -> {
                    result.throwable.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun refreshDataOfIndia() {
        try {
            when (val result = covidApiService.getData()
                .executeWithRetry().toResult(dataApiResponseToStateEntity.toLambda())) {
                is Success -> {
                    covidDatabase.insertStateWiseData(result.data)
                }
                is ErrorResult -> {
                    result.throwable.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}