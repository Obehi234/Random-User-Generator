package com.example.randomuserapplication.db

import androidx.lifecycle.LiveData
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
    fun getAllUsers() : LiveData<List<UserEntity>>

    @Query("SELECT * FROM $USER_TABLE WHERE id = :id OR FirstName = :firstName LIMIT 1")
    suspend fun getSingleUserByIdOrFirstName(id: String, firstName: String): UserEntity


}