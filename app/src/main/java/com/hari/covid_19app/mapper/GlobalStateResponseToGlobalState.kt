package com.hari.covid_19app.mapper

import com.hari.covid_19app.api.response.GlobalStateResponse
import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.model.Mapper
import javax.inject.Inject

class GlobalStateResponseToGlobalState @Inject constructor() :
    Mapper<GlobalStateResponse, GlobalState> {
    override suspend fun map(from: GlobalStateResponse): GlobalState {
        return from.results.map { result ->
            GlobalState(
                id = 0,
                totalActiveCases = result.totalActiveCases,
                totalAffectedCountries = result.totalAffectedCountries,
                totalCases = result.totalCases,
                totalDeaths = result.totalDeaths,
                totalNewCasesToday = result.totalNewCasesToday,
                totalNewDeathsToday = result.totalNewDeathsToday,
                totalRecovered = result.totalRecovered,
                totalSeriousCases = result.totalSeriousCases,
                totalUnresolved = result.totalUnresolved
            )
        }.first()
    }
}