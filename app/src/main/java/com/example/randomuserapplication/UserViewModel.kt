package com.example.randomuserapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    fun getUsersFromApiToDatabase() {
        viewModelScope.launch {
            repository.fetchAndSaveUsers()
        }
    }
}