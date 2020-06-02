package com.hari.covid_19app.repository.impl

import com.hari.covid_19app.api.CovidApiService
import com.hari.covid_19app.db.CovidDatabase
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.mapper.DataApiResponseToStateEntity
import com.hari.covid_19app.model.ErrorResult
import com.hari.covid_19app.model.Success
import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.utils.ext.executeWithRetry
import com.hari.covid_19app.utils.ext.toResult
import com.hari.tmdb.model.mapper.toLambda
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CovidRepositoryImp @Inject constructor(
    private val covidApiService: CovidApiService,
    private val covidDatabase: CovidDatabase,
    private val dataApiResponseToStateEntity: DataApiResponseToStateEntity
) : CovidRepository {

    override fun getTotalCaseInIndia(): Flow<State> {
        return covidDatabase.getTotalCaseInIndia()
    }

    override fun getAllStates(): Flow<List<State>> = covidDatabase.getAllStates()

    override suspend fun refreshData() {
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
        }
    }
}