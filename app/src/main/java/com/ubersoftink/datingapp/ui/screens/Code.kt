package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object CodeDestination: NavigationDestination{
    override val route = "verification code"
    override val titleRes = R.string.verify_code
}

@Composable
fun CodeScreen(){}

@Composable
@Preview
fun CodeScreenPreview(){}