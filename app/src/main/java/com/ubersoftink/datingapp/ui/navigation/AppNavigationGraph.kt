package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.MainScreen
import com.ubersoftink.datingapp.ui.screens.code.CodeVerificationScreen
import com.ubersoftink.datingapp.ui.screens.number.NumberScreen
import com.ubersoftink.datingapp.ui.screens.signup.SignUpScreen
import com.ubersoftink.datingapp.ui.screens.OnBoardingScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.InterestsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.NotificationsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.ProfileDetailsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.SexScreen
import com.ubersoftink.datingapp.ui.viewmodels.RegistrationViewModel

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
            OnBoardingScreen(
                onCreateAccountButton = {
                    navController.navigate(Routes.SIGN_UP)
                },
                onNavigateToAuth = {
                }
            )
        }

        registrationGraph(navController)

        mainGraph(navController)
    }
}