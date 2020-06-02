package com.hari.covid_19app.db

import androidx.room.withTransaction
import com.hari.covid_19app.db.dao.StateDao
import com.hari.covid_19app.db.entity.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val stateDao: StateDao
) : CovidDatabase {
    override fun getTotalCaseInIndia(): Flow<State> = stateDao.getTotalCaseInIndia()

    override fun getAllStates(): Flow<List<State>> = stateDao.getAllStates()

    override suspend fun insertStateWiseData(states: List<State>) {
        cacheDatabase.withTransaction {
            stateDao.deleteAll()
            stateDao.insert(states)
        }
    }

}