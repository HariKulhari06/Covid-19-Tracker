package com.hari.covid_19app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hari.covid_19app.db.dao.UserDao
import com.hari.covid_19app.model.User

@Database(entities = [User::class], version = 1)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    fun sqlite(): SupportSQLiteDatabase {
        return mDatabase
    }
}