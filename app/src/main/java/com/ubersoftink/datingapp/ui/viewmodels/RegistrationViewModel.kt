package com.ubersoftink.datingapp.ui.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.ubersoftink.datingapp.data.models.UserRegistrationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class RegistrationViewModel: ViewModel() {
    private val _state = MutableStateFlow(UserRegistrationState())
    val state = _state.asStateFlow()

    fun firstNameChanged(name: String){
        _state.update { it.copy(
            name = name
        ) }
    }

    fun lastNameChanged(lastName: String){
        _state.update { it.copy(
            lastName = lastName
        ) }
    }

    fun onProfilePictureSelected(uri: Uri?) {
        _state.update { it.copy(
            profilePicture = uri?.toString()
        ) }
    }

    fun saveBirthDate(birthDate: LocalDate?){
        _state.update { it.copy(
            birthDate = birthDate
        ) }
    }
}