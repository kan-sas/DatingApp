package com.ubersoftink.datingapp.ui.screens.mainscreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object ProfileDestination: NavigationDestination{
    override val route = "profile"
    override val titleRes = R.string.profile
}

@Composable
fun ProfileScreen(){}

@Preview
@Composable
fun ProfileScreenPreview(){}