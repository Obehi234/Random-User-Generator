package com.example.randomuserapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapplication.db.UserEntity
import com.example.randomuserapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
   private val userRepository: UserRepository
) : ViewModel() {

    val usersList: List<UserEntity> = userRepository.getUsersFromDatabase()

    fun addUsersToDatabase() {
        viewModelScope.launch {
            userRepository.fetchAndSaveUsers()
        }
    }

    fun getUserList() : List<UserEntity> {
        return usersList
    }


}