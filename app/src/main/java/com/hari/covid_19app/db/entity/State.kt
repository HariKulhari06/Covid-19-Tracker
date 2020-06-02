package com.hari.covid_19app.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hari.covid_19app.model.CovidEntity

@Entity(tableName = "state")
data class State(
    @PrimaryKey(autoGenerate = true) override val id: Int = 0,
    @ColumnInfo(name = "active") val active: String? = null,
    @ColumnInfo(name = "confirmed") val confirmed: String? = null,
    @ColumnInfo(name = "deaths") val deaths: String? = null,
    @ColumnInfo(name = "delta_confirmed") val deltaConfirmed: String? = null,
    @ColumnInfo(name = "delta_deaths") val deltaDeaths: String? = null,
    @ColumnInfo(name = "delta_recovered") val deltaRecovered: String? = null,
    @ColumnInfo(name = "last_updated_time") val lastUpdatedTime: String? = null,
    @ColumnInfo(name = "migrated_other") val migratedOther: String? = null,
    @ColumnInfo(name = "recovered") val recovered: String? = null,
    @ColumnInfo(name = "state") val state: String? = null,
    @ColumnInfo(name = "state_code") val stateCode: String? = null,
    @ColumnInfo(name = "state_notes") val stateNotes: String? = null
) : CovidEntity