package com.hari.covid_19app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.hari.covid_19app.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}