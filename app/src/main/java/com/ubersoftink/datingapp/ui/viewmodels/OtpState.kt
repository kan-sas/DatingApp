package com.ubersoftink.datingapp.ui.viewmodels

data class OtpState(
    val code : List<Int?> = (1..4).map { null },
    val focusedIndex: Int? = 0,
    val isValid: Boolean? = null
)
