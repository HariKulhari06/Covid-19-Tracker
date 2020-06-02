package com.hari.covid_19app.api

import com.hari.covid_19app.api.response.DataApiResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * REST API access points
 */
interface CovidApiService {

    /**
     * National Level :Time series, State-wise stats and Test counts
     */
    @GET("data.json")
    fun getData(): Call<DataApiResponse>


}