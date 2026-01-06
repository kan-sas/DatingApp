package com.ubersoftink.datingapp.ui.screens

import android.app.Notification
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object NotificationDestination: NavigationDestination{
    override val route = "notification"
    override val titleRes = R.string.notification
}

@Composable
fun NotificationScreen(){}

@Preview
@Composable
fun NotificationScreenPreview(){}