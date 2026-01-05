package com.ubersoftink.datingapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object CalendarDestination: NavigationDestination{
    override val route = "calendar"
    override val titleRes = R.string.calendar
}

/**
 * Реализовать через BottomSheetScaffold
 * */
@Composable
fun CalendarScreen(){}

@Preview
@Composable
fun CalendarPreview(){}