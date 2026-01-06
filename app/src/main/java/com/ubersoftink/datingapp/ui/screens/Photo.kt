package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object PhotoDestination: NavigationDestination{
    override val route = "photo_fullscreen"
    override val titleRes = R.string.photo
}

@Composable
fun PhotoFullscreen(){}

@Preview
@Composable
fun PhotoFullscreenPreview(){}