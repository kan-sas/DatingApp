package com.ubersoftink.datingapp.ui.screens.mainscreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object ChatDestination: NavigationDestination{
    override val route = "chat"
    override val titleRes = R.string.chat   //Исправить потом
}

@Composable
fun ChatScreen(){}

@Preview
@Composable
fun ChatScreenPreview(){}