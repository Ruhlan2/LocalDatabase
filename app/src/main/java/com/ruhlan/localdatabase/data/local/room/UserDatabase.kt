package com.ruhlan.localdatabase.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created on 29 Mar 2025,12:39
 * @author Ruhlan Usubov
 */
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}