package com.example.randomuserapplication.network

import com.example.randomuserapplication.model.UserList
import com.example.randomuserapplication.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET(END_POINT)
    suspend fun getAllUsers() : Response<UserList>
}