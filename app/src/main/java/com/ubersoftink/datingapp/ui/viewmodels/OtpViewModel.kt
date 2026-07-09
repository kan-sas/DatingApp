package com.ubersoftink.datingapp.ui.viewmodels

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.concurrent.TimeUnit

class OtpViewModel: ViewModel() {
    private val _state = MutableStateFlow(OtpState())
    val state = _state.asStateFlow()

    fun onAction(action: OtpAction){
        when(action){
            is OtpAction.OnChangeFieldFocused -> {
                _state.update{
                    it.copy(
                        focusedIndex = action.index
                    )
                }
            }
            is OtpAction.OnEnterNumber -> {
                enterNumber(action.number, action.index)
            }
            OtpAction.OnKeyBoardBack -> {
                deleteNumber()
            }
        }
    }

    fun secondHasPassed(){
        val timerSeconds = state.value.currentTime.plus(1)
        _state.update { it.copy(
            currentTime = timerSeconds
        ) }
    }

    private fun resetTheTimer(){
        _state.update { it.copy(
            currentTime = 0
        ) }
    }

    fun updateVerificationId(verificationId: String?){
        _state.update {
            it.copy(verificationId = verificationId)
        }
    }

    private fun deleteNumber(){
        val previousIndex = getPreviousFocusedIndex(state.value.focusedIndex)
        state.value.focusedIndex?.let {
            if(state.value.code[it] != null){
                _state.update { it.copy(
                    code = it.code.mapIndexed { index, number ->
                        if(index == previousIndex?.plus(1)){
                            null
                        }else{
                            number
                        }
                    }
                ) }
            }
            else{
                _state.update { it.copy(
                    code = it.code.mapIndexed { index, number ->
                        if(index == previousIndex) {
                            null
                        }else{
                            number
                        }
                    },
                    focusedIndex = previousIndex
                ) }
            }
        }
    }

    fun phoneAuthentication(
        context: Context,
        phoneNumber: String?
    ){
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber(phoneNumber!!)
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
                    _state.update { it.copy(
                        verificationId = verificationID
                    ) }
                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        resetTheTimer()
    }

    private fun enterNumber(number: Int?, index: Int){
        val newCode = state.value.code.mapIndexed{ currentIndex, currentNumber ->
            if(currentIndex == index){
                number
            } else{
                currentNumber
            }
        }
        val wasNumberRemoved = number == null
        val codeNotEmpty = newCode.none { it == null }
        val verificationId = state.value.verificationId

        _state.update {
            it.copy(
                code = newCode,
                focusedIndex = if (wasNumberRemoved || it.code.getOrNull(index) != null) {
                    it.focusedIndex
                } else {
                    getNextFocusedTextFieldIndex(
                        currentCode = it.code,
                        currentFocusedIndex = it.focusedIndex
                    )
                },
            )
        }

        if(codeNotEmpty){
            if(verificationId.isNullOrEmpty()){
                Log.e("OtpViewModel", "Verification ID is null or empty. Cannot proceed with Firebase auth.")
                _state.update { it.copy(isValid = false) }
                return
            }
            val codeString = newCode.joinToString("")
            try {
                val credential = PhoneAuthProvider.getCredential(
                    _state.value.verificationId!!,
                    codeString
                )
                Firebase.auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            _state.update {
                                it.copy(
                                    isValid = true
                                )
                            }
                        }
                    }
            }catch (e: IllegalArgumentException){
                _state.update { it.copy(isValid = false) }
            }
        }
    }

    private fun getPreviousFocusedIndex(currentIndex: Int?): Int?{
        return currentIndex?.minus(1)?.coerceAtLeast(0)
    }

    private fun getNextFocusedTextFieldIndex(
        currentCode: List<Int?>,
        currentFocusedIndex: Int?
    ): Int?{
        if(currentFocusedIndex == null){
            return null
        }
        if(currentFocusedIndex == 5){
            return currentFocusedIndex
        }
        return getFirstEmptyFieldIndexAfterFocusedIndex(
            code = currentCode,
            currentFocusedIndex = currentFocusedIndex
        )
    }

    private fun getFirstEmptyFieldIndexAfterFocusedIndex(
        code: List<Int?>,
        currentFocusedIndex: Int
    ): Int{
        code.forEachIndexed { index, number ->
            if(index <= currentFocusedIndex){
                return@forEachIndexed
            }
            if(number == null){
                return index
            }
        }
        return currentFocusedIndex
    }
}