package com.ruhlan.localdatabase.data.repository

import com.ruhlan.localdatabase.data.local.room.User
import com.ruhlan.localdatabase.data.local.room.UserDao
import com.ruhlan.localdatabase.data.local.sp.SharedPreferenceManager
import javax.inject.Inject

/**
 * Created on 29 Mar 2025,12:45
 * @author Ruhlan Usubov
 */
class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val sharedPreferenceManager: SharedPreferenceManager
) {
    suspend fun getAllUsers() = userDao.getAllUser()

    suspend fun insertNewUser(user: User) = userDao.addUser(user)

    suspend fun deleteExistedUser(user: String) = userDao.deleteUser(user)

    fun setRegisterFinished(isFinished: Boolean) =
        sharedPreferenceManager.setIsRegisterFinished(isFinished)

    fun getRegisterFinished() = sharedPreferenceManager.getIsRegisterFinished()
}