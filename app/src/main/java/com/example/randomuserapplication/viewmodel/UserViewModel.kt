package com.example.randomuserapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.randomuserapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    userRepository: UserRepository
) : ViewModel() {


}