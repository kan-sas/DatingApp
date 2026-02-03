package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.OnBoardingScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.ON_BOARDING
    ) {
        composable(route = Routes.CATS_LIST) {
            CatsListScreen()
        }
        composable(route = Routes.ON_BOARDING) {
            OnBoardingScreen()
        }
    }
}