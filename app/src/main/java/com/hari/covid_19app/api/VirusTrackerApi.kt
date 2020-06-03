package com.hari.covid_19app.api

import com.hari.covid_19app.api.response.GlobalStateResponse
import retrofit2.Call
import retrofit2.http.GET

interface VirusTrackerApi {
    @GET("free-api?global=stats")
    fun getGlobalState(): Call<GlobalStateResponse>
}