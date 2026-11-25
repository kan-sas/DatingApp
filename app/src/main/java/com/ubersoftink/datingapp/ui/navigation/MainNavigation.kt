package com.ubersoftink.datingapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ubersoftink.datingapp.ui.screens.MainScreen

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(
        startDestination = Routes.MAIN_SCREEN,
        route = Graph.MAIN
    ) {
        composable(route = Routes.MAIN_SCREEN) {
            MainScreen()
        }
    }
}