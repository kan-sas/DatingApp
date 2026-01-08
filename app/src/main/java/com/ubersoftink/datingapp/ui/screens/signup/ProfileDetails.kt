package com.ubersoftink.datingapp.ui.screens.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object ProfileDetailsDestination: NavigationDestination{
    override val route = "profile details"
    override val titleRes = R.string.profile_details
}

@Composable
fun ProfileDetailsScreen(){}

@Composable
@Preview
fun ProfileDetailsScreenPreview(){}