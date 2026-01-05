package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ubersoftink.datingapp.ui.screens.StartDestination
import com.ubersoftink.datingapp.ui.screens.StartScreen

@Composable
fun DatingNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    NavHost(
        navController = navController, startDestination = StartDestination.route, modifier = modifier,
    ){}
}