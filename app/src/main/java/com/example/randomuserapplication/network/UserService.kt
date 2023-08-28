package com.example.randomuserapplication.network

import com.example.randomuserapplication.data.model.UserList
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("api/?results=500")
    suspend fun getAllUsers() : Response<UserList>
}