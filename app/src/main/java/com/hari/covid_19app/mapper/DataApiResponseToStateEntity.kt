package com.hari.covid_19app.mapper

import com.hari.covid_19app.api.response.DataApiResponse
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.model.Mapper
import javax.inject.Inject

class DataApiResponseToStateEntity @Inject constructor() : Mapper<DataApiResponse, List<State>> {
    override suspend fun map(from: DataApiResponse): List<State> {
        return from.statewise.map { stateWise ->
            State(
                active = stateWise.active,
                confirmed = stateWise.confirmed,
                deaths = stateWise.deaths,
                deltaConfirmed = stateWise.deltaconfirmed,
                deltaDeaths = stateWise.deltadeaths,
                deltaRecovered = stateWise.deltarecovered,
                lastUpdatedTime = stateWise.lastupdatedtime,
                migratedOther = stateWise.migratedother,
                recovered = stateWise.recovered,
                state = stateWise.state,
                stateCode = stateWise.statecode,
                stateNotes = stateWise.statenotes
            )
        }
    }
}