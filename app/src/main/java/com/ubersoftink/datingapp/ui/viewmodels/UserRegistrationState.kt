package com.ubersoftink.datingapp.ui.viewmodels

import java.time.LocalDate

data class UserRegistrationState(
    val name: String = "",
    val lastName: String = "",
    val birthDate: LocalDate? = null,
    val selectedGender: String? = null,
    val bio: List<String> = emptyList(),
    val photos: MutableList<String> = mutableListOf(),
    val profilePicture: String? = null,
    val showWarning: Boolean = false,
    val buttonIsClickable: Boolean = false,
    val phoneNumber: String? = "",
    val verificationId: String? = "",
)