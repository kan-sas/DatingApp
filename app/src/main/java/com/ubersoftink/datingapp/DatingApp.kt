package com.ubersoftink.datingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.navigation.DatingNavHost

@Composable
fun DatingApp(navController: NavHostController = rememberNavController()){
    DatingNavHost(navController = navController)
}

/**
 * Навигация по кнопкам снизу экрана
 * */
@Composable
fun DatingBottomAppBar(
){}