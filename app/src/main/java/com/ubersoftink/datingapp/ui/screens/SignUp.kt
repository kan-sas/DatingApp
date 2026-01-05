package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object SignUpDestination: NavigationDestination{
    override val route = "sign up"
    override val titleRes = R.string.sign_up
}

@Composable
fun SignUpScreen(){}

@Composable
@Preview
fun SignUpScreenPreview(){}