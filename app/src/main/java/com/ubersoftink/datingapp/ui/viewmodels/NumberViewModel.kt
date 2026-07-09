package com.ubersoftink.datingapp.ui.viewmodels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ubersoftink.datingapp.data.PhoneCode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.concurrent.TimeUnit

data class NumberState(
    val numberWithoutCode: String = "",
    val phoneCode: String = PhoneCode.values()[0].code.toString(),
)

class NumberViewModel: ViewModel() {
    private val _state = MutableStateFlow(NumberState())
    val state = _state.asStateFlow()

    fun phoneAuthentication(
        context: Context,
        onContinueButton: (String, String) -> Unit,
    ){
        val phoneNumber = "+${_state.value.phoneCode}${_state.value.numberWithoutCode}"
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(context as Activity)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful){
                            //change to navigate to profile details
                            //navController.navigate(Routes.SIGN_UP)
                        }
                    }
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Toast.makeText(context, "Verification failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }

                override fun onCodeSent(
                    verificationID: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    onContinueButton(verificationID, phoneNumber)
                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun codeChanged(index: Int){
        _state.update { it.copy(
            phoneCode = PhoneCode.values()[index?:0].code.toString()
        ) }
    }

    fun numberWithoutCodeChanged(newNumber: String){
        _state.update { it.copy(
            numberWithoutCode = newNumber
        ) }
    }
}