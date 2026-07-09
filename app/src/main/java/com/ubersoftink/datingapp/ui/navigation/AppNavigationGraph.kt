package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.code.CodeVerificationScreen
import com.ubersoftink.datingapp.ui.screens.number.NumberScreen
import com.ubersoftink.datingapp.ui.screens.signup.SignUpScreen
import com.ubersoftink.datingapp.ui.screens.OnBoardingScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.ProfileDetailsScreen

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
        composable(route = Routes.SIGN_UP) {
            SignUpScreen(enterByPhoneNumberButton = {
                navController.navigate(Routes.NUMBER_ENTER)
            })
        }
        composable(route = Routes.NUMBER_ENTER) {
            NumberScreen(
                onContinueButton = { verificationId, phoneNumber ->
                    navController.navigate("${Routes.VERIFICATION_SCREEN}/$verificationId/$phoneNumber")
                }
            )
        }
        composable(
            route = "${Routes.VERIFICATION_SCREEN}/{verificationId}/{phoneNumber}",
            arguments = listOf(
                navArgument("verificationId") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument("phoneNumber"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber")
            val verificationId = backStackEntry.arguments?.getString("verificationId")
            CodeVerificationScreen(
                navigateUp = {
                    navController.navigate(Routes.NUMBER_ENTER) {
                        popUpTo(Routes.NUMBER_ENTER) { inclusive = false }
                    }
                },
                verificationId = verificationId,
                phoneNumber = phoneNumber,
                toProfileDetails = {
                    navController.navigate(Routes.PROFILE_DETAILS)
                }
            )
        }
        composable(route = Routes.PROFILE_DETAILS){
            ProfileDetailsScreen()
        }
    }
}