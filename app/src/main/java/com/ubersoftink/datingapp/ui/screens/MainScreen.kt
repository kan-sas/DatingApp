package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object MainScreenDestination: NavigationDestination{
    override val route = "main"
    override val titleRes = R.string.main_screen
}

@Composable
fun MainScreen(){}

@Preview
@Composable
fun MainScreenPreview(){}