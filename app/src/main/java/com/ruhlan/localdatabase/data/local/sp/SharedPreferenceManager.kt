package com.ruhlan.localdatabase.data.local.sp

import android.content.SharedPreferences
import androidx.core.content.edit
import com.ruhlan.localdatabase.util.Constant
import javax.inject.Inject

/**
 * Created on 29 Mar 2025,11:42
 * @author Ruhlan Usubov
 */

class SharedPreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    // sp set,get

    fun setIsRegisterFinished(isFinished: Boolean) {
        sharedPreferences.edit {
            putBoolean(Constant.REGISTER, isFinished)
        }
    }

    fun getIsRegisterFinished(): Boolean {
        return sharedPreferences.getBoolean(Constant.REGISTER, false)
    }
}

// Room -> Dao,Db,Entity 