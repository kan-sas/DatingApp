package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun DatingNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
){
    NavHost(
        navController = navController, startDestination = {}, modifier = modifier,
    ){}
}