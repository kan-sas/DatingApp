package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        SignUpContent()
    }
}