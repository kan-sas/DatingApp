package com.ubersoftink.datingapp.ui.screens.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object StartDestination: NavigationDestination{
    override val route = "start"
    override val titleRes = R.string.welcome
}

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
){

}

@Composable
@Preview
fun StartScreenPreview(){}