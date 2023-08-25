package com.example.randomuserapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapplication.db.UserEntity
import com.example.randomuserapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private var _userList = MutableLiveData<List<UserEntity>>()
    val userList: LiveData<List<UserEntity>> get() = _userList

    private var _searchList = MutableLiveData<List<UserEntity>>()
    val searchList: LiveData<List<UserEntity>> get() = _searchList

    init {
        addUsersToDatabase()
        observeUserListFromDatabase()
    }

    private fun addUsersToDatabase() {
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

    suspend fun getSingleUser(userId: String): UserEntity {
        return userRepository.getSingleUserById(userId)
    }

    fun searchUsers(searchQuery: String) {
        viewModelScope.launch {
            if (searchQuery.isNotEmpty()) {
                val searchUser = withContext(Dispatchers.IO) {
                    userRepository.searchUserByName(searchQuery)
                }
                _searchList.postValue(searchUser)
            }else{
                observeUserListFromDatabase()
            }


        }

    }
}