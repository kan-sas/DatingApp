package com.ubersoftink.datingapp.ui.viewmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.ubersoftink.datingapp.ui.viewmodels.UserRegistrationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class RegistrationViewModel: ViewModel() {
    private val _state = MutableStateFlow(UserRegistrationState())
    val state = _state.asStateFlow()

    fun isNameFieldFilled(){
        if (_state.value.name.isEmpty() || _state.value.lastName.isEmpty()){
            _state.update { it.copy(
                showWarning = true
            ) }
        }else if(!_state.value.name.isEmpty() && !_state.value.lastName.isEmpty()){
            _state.update { it.copy(
                buttonIsClickable = true
            ) }
        }
    }

    fun setPhoneVerificationData(verificationId: String?, phoneNumber: String?){
        _state.update { it.copy(
            verificationId = verificationId,
            phoneNumber = phoneNumber
        ) }
    }

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

    fun onGenderSelected(gender: String){
        _state.update { it.copy(
            selectedGender = gender
        ) }
    }

    fun updateInterests(interest: String) {
        _state.update { currentState ->
            val updatedList = if (currentState.bio.contains(interest)) {
                currentState.bio - interest
            } else {
                currentState.bio + interest
            }

            currentState.copy(
                bio = updatedList
            )
        }
    }
}