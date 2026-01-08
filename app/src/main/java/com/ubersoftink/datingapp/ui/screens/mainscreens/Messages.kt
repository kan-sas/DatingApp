package com.ubersoftink.datingapp.ui.screens.mainscreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object MessagesDestination: NavigationDestination{
    override val route = "messages"
    override val titleRes = R.string.messages
}

@Composable
fun MessagesScreen(){}

@Preview
@Composable
fun MessagesScreenPreview(){}