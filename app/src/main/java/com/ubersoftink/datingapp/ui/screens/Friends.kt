package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object FriendDestination: NavigationDestination{
    override val route = "friends"
    override val titleRes = R.string.friends
}

@Composable
fun FriendsScreen(){}

@Preview
@Composable
fun FriendsScreenPreview(){}