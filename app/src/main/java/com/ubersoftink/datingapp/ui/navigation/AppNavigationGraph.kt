package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.code.CodeVerificationScreen
import com.ubersoftink.datingapp.ui.screens.number.NumberScreen
import com.ubersoftink.datingapp.ui.screens.signup.SignUpScreen
import com.ubersoftink.datingapp.ui.viewmodels.OtpViewModel
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
        composable(route = Routes.SIGN_UP) {
            SignUpScreen(enterByPhoneNumberButton = {
                navController.navigate(Routes.NUMBER_ENTER)
            })
        }
        composable(route = Routes.NUMBER_ENTER) {
            NumberScreen(
                onContinueButton = { verificationId ->
                    navController.navigate("${Routes.VERIFICATION_SCREEN}/$verificationId")
                }
            )
        }
        composable(
            route = "${Routes.VERIFICATION_SCREEN}/{verificationId}",
            arguments = listOf(
                navArgument("verificationId") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val verificationId = backStackEntry.arguments?.getString("verificationId")
            CodeVerificationScreen(
                navigateUp = {
                    navController.navigate(Routes.NUMBER_ENTER) {
                        popUpTo(Routes.NUMBER_ENTER) { inclusive = false }
                    }
                },
                verificationId = verificationId,
            )
        }
        composable(route = Routes.ON_BOARDING) {
            OnBoardingScreen(
                onCreateAccountButton = {},
                onNavigateToAuth  = {
                }
            )
        }
    }
}