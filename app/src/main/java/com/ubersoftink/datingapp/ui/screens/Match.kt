package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object MatchDestination: NavigationDestination{
    override val route = "match"
    override val titleRes = R.string.match
}

@Composable
fun MatchScreen(){}

@Preview
@Composable
fun MatchScreenPreview(){}