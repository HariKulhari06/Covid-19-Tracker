package com.hari.covid_19app.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hari.covid_19app.db.entity.GlobalState
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GlobalStateDao : EntityDao<GlobalState> {
    @Query("select * from global_state limit 1")
    abstract fun getGlobalState(): Flow<GlobalState>

    @Query("delete from global_state")
    abstract suspend fun deleteAll()
}