package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel

@Composable
fun AppNavGraph(catViewModel: CatsListViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.CATS_LIST
    ) {
        composable(route = Routes.CATS_LIST) {
            CatsListScreen(catViewModel = catViewModel)
        }
    }
}