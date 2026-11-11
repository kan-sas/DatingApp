package com.ubersoftink.datingapp.data.models

import java.time.LocalDate

data class UserRegistrationState(
    val name: String = "",
    val lastName: String = "",
    val birthDate: LocalDate? = null,
    val gender: String? = null,
    val bio:  String? = "",
    val photos: MutableList<String> = mutableListOf(),
    val profilePicture: String? = null,
)