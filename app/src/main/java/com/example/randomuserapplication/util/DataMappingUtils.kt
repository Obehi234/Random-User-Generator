package com.example.randomuserapplication.util

import com.example.randomuserapplication.data.db.UserEntity
import com.example.randomuserapplication.data.model.Result

object DataMappingUtils {
    fun mapResultToUserEntity(result: Result): UserEntity {
        return UserEntity(
            city = result.location.city,
            country = result.location.country,
            state = result.location.state,
            streetName = result.location.street.name,
            streetNumber = result.location.street.number,
            title = result.name.title,
            firstName = result.name.first,
            lastName = result.name.last,
            gender = result.gender,
            dob = result.dob.age,
            nat = result.nat,
            pictureUrl = result.picture.thumbnail,
            pictureLarge = result.picture.medium,
            userName = result.login.username
        )
    }
}