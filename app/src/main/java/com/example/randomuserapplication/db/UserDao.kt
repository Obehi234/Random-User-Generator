package com.example.randomuserapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randomuserapplication.util.Constants.USER_TABLE

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDatabase(users: List<UserEntity>)

    @Query("SELECT * FROM $USER_TABLE")
    suspend fun getAllUsers() : List<UserEntity>

    @Query("SELECT * FROM $USER_TABLE WHERE ID = :id")
    suspend fun getSingleUserById(id: String): UserEntity

    @Query("SELECT * FROM $USER_TABLE WHERE FirstName LIKE :searchQuery OR LastName LIKE :searchQuery")
    suspend fun searchUserByName(searchQuery: String) : List<UserEntity>

}