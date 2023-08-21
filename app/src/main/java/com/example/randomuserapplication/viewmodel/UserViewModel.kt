package com.example.randomuserapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var _userList = MutableLiveData<List<UserEntity>>()

    val userList: LiveData<List<UserEntity>> get() = _userList

    init {
        observeUserListFromDatabase()
    }
    fun addUsersToDatabase() {
        viewModelScope.launch {
            userRepository.fetchAndSaveUsers()
        }
    }

     private fun observeUserListFromDatabase() {
        viewModelScope.launch {
            val users = userRepository.getUsersFromDatabase()
            _userList.postValue(users)
        }
    }

}