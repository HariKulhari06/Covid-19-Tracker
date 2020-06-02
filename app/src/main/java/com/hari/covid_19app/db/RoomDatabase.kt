package com.hari.covid_19app.db

import com.hari.covid_19app.db.dao.UserDao
import com.hari.covid_19app.model.User
import javax.inject.Inject


class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val userDao: UserDao
) : CovidDatabase {
    override suspend fun insert(user: User) {
        userDao.insert(user)
    }
}