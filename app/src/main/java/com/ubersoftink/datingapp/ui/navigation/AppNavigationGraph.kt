package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.screens.CatsListScreen
import com.ubersoftink.datingapp.ui.screens.code.CodeVerificationScreen
import com.ubersoftink.datingapp.ui.screens.number.NumberScreen
import com.ubersoftink.datingapp.ui.screens.signup.SignUpScreen

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
            SignUpScreen(enterByPhoneNumberButton = {
                navController.navigate(Routes.NUMBER_ENTER)
            })
        }
        composable(route = Routes.NUMBER_ENTER) {
            NumberScreen(
                //Убрать navController из параметров перенести во viewModel инф-у о verificationId
                //navController = navController,
                onContinueButton = {navController.navigate((Routes.VERIFICATION_SCREEN))}
            )
        }
        composable(route = Routes.VERIFICATION_SCREEN) {
            CodeVerificationScreen(
                navigateUp = { navController.navigate(Routes.NUMBER_ENTER) }
            )
        }
    }
}