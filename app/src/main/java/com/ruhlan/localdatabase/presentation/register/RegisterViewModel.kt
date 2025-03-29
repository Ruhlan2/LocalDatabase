package com.ruhlan.localdatabase.presentation.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruhlan.localdatabase.data.local.room.User
import com.ruhlan.localdatabase.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * Created on 29 Mar 2025,12:43
 * @author Ruhlan Usubov
 */
@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    val isRegisterFinished = MutableLiveData<Boolean>()
    val userData = MutableLiveData<List<User>>()

    init {
        getRegister()
        getAllUser()
    }

    fun getRegister() {
        isRegisterFinished.value = repository.getRegisterFinished()
    }

    fun setRegister(isFinished: Boolean) {
        viewModelScope.launch {
            repository.setRegisterFinished(isFinished)
        }
        getRegister()
    }

    fun getAllUser() {
        viewModelScope.launch {
            userData.value = repository.getAllUsers()
        }
    }

    fun insertNewUser(email: String, password: String) {
        viewModelScope.launch {
            repository.insertNewUser(
                user = User(
                    email = email,
                    password = password
                )
            )
        }
    }

    fun deleteExistedUser(email: String) {
        viewModelScope.launch {
            try {
                repository.deleteExistedUser(
                    user = email
                )
            } catch (e: Exception) {
                Log.e("TAG", "deleteExistedUser: $e")
            }
        }
    }
}