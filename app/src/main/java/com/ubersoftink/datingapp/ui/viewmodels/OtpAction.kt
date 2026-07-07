package com.ubersoftink.datingapp.ui.viewmodels

sealed interface OtpAction {
    data class OnEnterNumber(val number: Int?, val index: Int): OtpAction
    data class OnChangeFieldFocused(val index: Int): OtpAction
    data object OnKeyBoardBack: OtpAction
}