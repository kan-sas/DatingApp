package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object MatchesDestination: NavigationDestination{
    override val route = "matches"
    override val titleRes = R.string.matches
}

@Composable
fun MatchesScreen(){}

@Preview
@Composable
fun MatchesScreenPreview(){}