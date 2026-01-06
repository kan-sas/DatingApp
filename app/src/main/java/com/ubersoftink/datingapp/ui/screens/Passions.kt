package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object PassionDestination: NavigationDestination{
    override val route = "passion"
    override val titleRes = R.string.passions
}

@Composable
fun PassionsScreen(){}

@Preview
@Composable
fun PassionsScreenPreview(){}