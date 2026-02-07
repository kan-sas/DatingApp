package com.ubersoftink.datingapp.ui.screens.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    enterByPhoneNumberButton: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        SignUpContent(enterByPhoneNumberButton = enterByPhoneNumberButton)
    }
}