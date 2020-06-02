package com.hari.covid_19app.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hari.covid_19app.db.entity.State
import kotlinx.coroutines.flow.Flow

@Dao
abstract class StateDao : EntityDao<State> {

    @Query("select * from state where state_code='TT'")
    abstract fun getTotalCaseInIndia(): Flow<State>

    @Query("select * from state")
    abstract fun getAllStates(): Flow<List<State>>

    @Query("delete from state")
    abstract suspend fun deleteAll()

}