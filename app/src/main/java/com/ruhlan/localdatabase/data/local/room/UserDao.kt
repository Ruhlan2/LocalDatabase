package com.ruhlan.localdatabase.data.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

/**
 * Created on 29 Mar 2025,12:36
 * @author Ruhlan Usubov
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUser(): List<User>

    @Upsert
    suspend fun addUser(user: User)

    @Query("DELETE FROM user WHERE :userEmail = email")
    suspend fun deleteUser(userEmail: String)
}