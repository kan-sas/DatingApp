package com.ubersoftink.datingapp.data.models

data class UserRequestDto(
    val name: String,
    val lastName: String,
    val birthDate: String?,
    val gender: String?,
    val bio: List<String>,
    val profilePictureUrl: String?
    /*
    val phoneNumber: String?
    val verificationId: String?*/
)