package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.SignUpScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SIGN_UP
    ) {
        composable(route = Routes.CATS_LIST) {
            CatsListScreen()
        }
        composable(route = Routes.SIGN_UP) {
            SignUpScreen()
        }
    }
}