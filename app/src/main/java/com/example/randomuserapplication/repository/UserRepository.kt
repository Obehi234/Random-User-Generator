package com.example.randomuserapplication.repository

import android.util.Log
import com.example.randomuserapplication.db.UserDao
import com.example.randomuserapplication.db.UserEntity
import com.example.randomuserapplication.network.UserService
import com.example.randomuserapplication.util.DataMappingUtils
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
) {

    suspend fun fetchAndSaveUsers() {
        try {
            val response = api.getAllUsers()
            if (response.isSuccessful) {
                val userList = response.body()?.results ?: emptyList()
                val userEntities = userList.map { result ->
                    val userEntity = DataMappingUtils.mapResultToUserEntity(result)
                    userEntity
                }
                userDao.insertToDatabase(userEntities)
            } else {
                Log.d("CHECK_DB", "Insertion to database failed: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("CHECK_DB", "Error fetching and saving users: ${e.message}")
        }
    }

    fun getUsersFromDatabase(): List<UserEntity> {
        return userDao.getAllUsers()
    }
}