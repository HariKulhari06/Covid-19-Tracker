package com.hari.covid_19app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hari.covid_19app.db.dao.GlobalStateDao
import com.hari.covid_19app.db.dao.StateDao
import com.hari.covid_19app.db.entity.GlobalState
import com.hari.covid_19app.db.entity.State

@Database(
    entities = [
        State::class,
        GlobalState::class
    ], version = 1
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun stateDao(): StateDao
    abstract fun globalStateDao(): GlobalStateDao

}