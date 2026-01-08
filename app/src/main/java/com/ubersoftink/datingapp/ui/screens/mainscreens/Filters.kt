package com.ubersoftink.datingapp.ui.screens.mainscreens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ubersoftink.datingapp.R
import com.ubersoftink.datingapp.ui.navigation.NavigationDestination

object FiltersDestination: NavigationDestination{
    override val route = "filters"
    override val titleRes = R.string.filters
}

/**
 * Реализовать через BottomSheetScaffold
 * */
@Composable
fun FiltersScreen(){}

@Composable
@Preview
fun FiltersScreenPreview(){}