package com.ruhlan.localdatabase.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ruhlan.localdatabase.data.local.room.UserDao
import com.ruhlan.localdatabase.data.local.room.UserDatabase
import com.ruhlan.localdatabase.data.local.sp.SharedPreferenceManager
import com.ruhlan.localdatabase.data.repository.UserRepository
import com.ruhlan.localdatabase.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created on 29 Mar 2025,11:38
 * @author Ruhlan Usubov
 */
@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    const val SP_NAME = "USER"

    @Provides
    @Singleton
    fun injectSp(@ApplicationContext context: Context) = context.getSharedPreferences(
        SP_NAME,
        Context.MODE_PRIVATE
    )

    @Provides
    @Singleton
    fun injectSpManager(sharedPreferences: SharedPreferences) =
        SharedPreferenceManager(sharedPreferences)

    @Provides
    @Singleton
    fun injectRoomDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        Constant.USER_DB
    ).build()

    @Provides
    @Singleton
    fun injectLocalDatabase(userDatabase: UserDatabase) = userDatabase.userDao()

    @Provides
    @Singleton
    fun injectRepository(userDao: UserDao, sharedPreferenceManager: SharedPreferenceManager) =
        UserRepository(userDao, sharedPreferenceManager)
}