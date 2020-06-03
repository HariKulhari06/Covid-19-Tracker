package com.hari.covid_19app.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hari.covid_19app.model.CovidEntity

@Entity(tableName = "global_state")
data class GlobalState(
    @PrimaryKey(autoGenerate = true) override val id: Int = 0,
    @ColumnInfo(name = "total_active_cases") val totalActiveCases: Int? = null,
    @ColumnInfo(name = "total_affected_countries") val totalAffectedCountries: Int? = null,
    @ColumnInfo(name = "total_cases") val totalCases: Int? = null,
    @ColumnInfo(name = "total_deaths") val totalDeaths: Int? = null,
    @ColumnInfo(name = "total_new_cases_today") val totalNewCasesToday: Int? = null,
    @ColumnInfo(name = "total_new_deaths_today") val totalNewDeathsToday: Int? = null,
    @ColumnInfo(name = "total_recovered") val totalRecovered: Int? = null,
    @ColumnInfo(name = "total_serious_cases") val totalSeriousCases: Int? = null,
    @ColumnInfo(name = "total_unresolved") val totalUnresolved: Int? = null
) : CovidEntity