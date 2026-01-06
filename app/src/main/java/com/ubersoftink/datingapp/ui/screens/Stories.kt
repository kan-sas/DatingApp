package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object StoriesDestination: NavigationDestination{
    override val route = "story"
    override val titleRes = R.string.stories
}

@Composable
fun StoriesScreen(){}

@Preview
@Composable
fun StoriesScreenPreview(){}