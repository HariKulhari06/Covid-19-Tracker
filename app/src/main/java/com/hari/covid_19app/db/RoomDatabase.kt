package com.hari.covid_19app.db

import androidx.room.withTransaction
import com.hari.covid_19app.db.dao.GlobalStateDao
import com.hari.covid_19app.db.dao.StateDao
import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject


class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val stateDao: StateDao,
    private val globalStateDao: GlobalStateDao
) : CovidDatabase {
    override fun getTotalCaseInIndia(): Flow<State> =
        stateDao.getTotalCaseInIndia().distinctUntilChanged()

    override fun getGlobalState(): Flow<GlobalState> =
        globalStateDao.getGlobalState().distinctUntilChanged()

    override fun getAllStates(): Flow<List<State>> = stateDao.getAllStates()

    override suspend fun insertStateWiseData(states: List<State>) {
        cacheDatabase.withTransaction {
            stateDao.deleteAll()
            stateDao.insert(states)
        }
    }

    override suspend fun insertGlobalStateData(data: GlobalState) {
        cacheDatabase.withTransaction {
            globalStateDao.deleteAll()
            globalStateDao.insert(data)
        }
    }


}