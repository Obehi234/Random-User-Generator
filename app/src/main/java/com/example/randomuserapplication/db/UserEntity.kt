package com.example.randomuserapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.randomuserapplication.util.Constants.USER_TABLE

@Entity(tableName = USER_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo("Title")
    val title: String,
    @ColumnInfo("FirstName")
    val firstName: String,
    @ColumnInfo("LastName")
    val lastName: String,
    @ColumnInfo("Gender")
    val gender: String,
    @ColumnInfo("Age")
    val dob: Int,
    @ColumnInfo("StreetNumber")
    val streetNumber: Int,
    @ColumnInfo("StreetName")
    val streetName: String,
    @ColumnInfo("City")
    val city: String,
    @ColumnInfo("State")
    val state: String,
    @ColumnInfo("Country")
    val country: String,
    @ColumnInfo("Nationality")
    val nat: String,
    @ColumnInfo("Picture")
    val pictureUrl: String,
    @ColumnInfo("PictureLarge")
    val pictureLarge: String,
    @ColumnInfo("UserName")
    val userName: String
)
