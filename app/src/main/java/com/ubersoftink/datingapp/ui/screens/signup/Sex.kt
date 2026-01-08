package com.ubersoftink.datingapp.ui.screens.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object SexDestination: NavigationDestination{
    override val route = "sex"
    override val titleRes = R.string.sex
}

@Composable
fun SexScreen(){}

@Composable
@Preview
fun SexScreenPreview(){}