package com.hari.covid_19app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hari.covid_19app.db.dao.StateDao
import com.hari.covid_19app.db.entity.State

@Database(
    entities = [
        State::class
    ], version = 1
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun stateDao(): StateDao

    fun sqlite(): SupportSQLiteDatabase {
        return mDatabase
    }
}