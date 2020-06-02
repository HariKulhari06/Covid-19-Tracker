package com.hari.covid_19app.api.response

import com.google.gson.annotations.SerializedName


data class DataApiResponse(
    @SerializedName("cases_time_series")
    val casesTimeSeries: List<CasesTimeSery>,
    @SerializedName("statewise")
    val statewise: List<Statewise>,
    @SerializedName("tested")
    val tested: List<Tested>
)

data class CasesTimeSery(
    @SerializedName("dailyconfirmed")
    val dailyconfirmed: String,
    @SerializedName("dailydeceased")
    val dailydeceased: String,
    @SerializedName("dailyrecovered")
    val dailyrecovered: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("totalconfirmed")
    val totalconfirmed: String,
    @SerializedName("totaldeceased")
    val totaldeceased: String,
    @SerializedName("totalrecovered")
    val totalrecovered: String
)

data class Statewise(
    @SerializedName("active")
    val active: String,
    @SerializedName("confirmed")
    val confirmed: String,
    @SerializedName("deaths")
    val deaths: String,
    @SerializedName("deltaconfirmed")
    val deltaconfirmed: String,
    @SerializedName("deltadeaths")
    val deltadeaths: String,
    @SerializedName("deltarecovered")
    val deltarecovered: String,
    @SerializedName("lastupdatedtime")
    val lastupdatedtime: String,
    @SerializedName("migratedother")
    val migratedother: String,
    @SerializedName("recovered")
    val recovered: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("statecode")
    val statecode: String,
    @SerializedName("statenotes")
    val statenotes: String
)

data class Tested(
    @SerializedName("individualstestedperconfirmedcase")
    val individualstestedperconfirmedcase: String,
    @SerializedName("positivecasesfromsamplesreported")
    val positivecasesfromsamplesreported: String,
    @SerializedName("samplereportedtoday")
    val samplereportedtoday: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("testpositivityrate")
    val testpositivityrate: String,
    @SerializedName("testsconductedbyprivatelabs")
    val testsconductedbyprivatelabs: String,
    @SerializedName("testsperconfirmedcase")
    val testsperconfirmedcase: String,
    @SerializedName("testspermillion")
    val testspermillion: String,
    @SerializedName("totalindividualstested")
    val totalindividualstested: String,
    @SerializedName("totalpositivecases")
    val totalpositivecases: String,
    @SerializedName("totalsamplestested")
    val totalsamplestested: String,
    @SerializedName("updatetimestamp")
    val updatetimestamp: String
)