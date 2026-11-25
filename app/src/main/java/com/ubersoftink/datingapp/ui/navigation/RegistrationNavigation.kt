package com.ubersoftink.datingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ubersoftink.datingapp.ui.screens.code.CodeVerificationScreen
import com.ubersoftink.datingapp.ui.screens.number.NumberScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.InterestsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.NotificationsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.ProfileDetailsScreen
import com.ubersoftink.datingapp.ui.screens.profiledetails.SexScreen
import com.ubersoftink.datingapp.ui.screens.signup.SignUpScreen
import com.ubersoftink.datingapp.ui.viewmodels.RegistrationViewModel

fun NavGraphBuilder.registrationGraph(navController: NavHostController) {
    navigation(
        startDestination = Routes.SIGN_UP,
        route = Graph.REGISTRATION
    ) {
        composable(route = Routes.SIGN_UP) {
            SignUpScreen(
                enterByPhoneNumberButton = {
                    navController.navigate(Routes.NUMBER_ENTER)
                }
            )
        }

        composable(route = Routes.NUMBER_ENTER) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            NumberScreen(
                onContinueButton = { verificationId, phoneNumber ->
                    sharedViewModel.setPhoneVerificationData(verificationId, phoneNumber)
                    navController.navigate(Routes.VERIFICATION_SCREEN)
                }
            )
        }

        composable(route = Routes.VERIFICATION_SCREEN) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            CodeVerificationScreen(
                regViewModel = sharedViewModel,
                navigateUp = {
                    navController.popBackStack()
                },
                toProfileDetails = {
                    navController.navigate(Routes.PROFILE_DETAILS) {
                        popUpTo(Routes.SIGN_UP) { inclusive = true }
                    }
                }
            )
        }

        composable(route = Routes.PROFILE_DETAILS) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            ProfileDetailsScreen(
                regViewModel = sharedViewModel,
                onSkipClick = { navController.navigate(Routes.I_AM) },
                toSexScreen = { navController.navigate(Routes.I_AM) }
            )
        }

        composable(route = Routes.I_AM) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            SexScreen(
                viewModel = sharedViewModel,
                onBackClick = { navController.popBackStack() },
                onContinueClick = { navController.navigate(Routes.PASSIONS) },
                onSkipClick = { navController.navigate(Routes.PASSIONS) }
            )
        }

        composable(route = Routes.PASSIONS) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            InterestsScreen(
                viewModel = sharedViewModel,
                onBackClick = { navController.popBackStack() },
                onContinueClick = { navController.navigate(Routes.ENABLE_NOTIFICATIONS) },
                onSkipClick = { navController.navigate(Routes.ENABLE_NOTIFICATIONS) }
            )
        }

        composable(route = Routes.ENABLE_NOTIFICATIONS) { backStackEntry ->
            val sharedViewModel = backStackEntry.sharedViewModel<RegistrationViewModel>(navController)

            val completeRegistrationAndNavigate = {
                // sharedViewModel.sendToServer()
                navController.navigate(Graph.MAIN) {
                    popUpTo(Routes.ON_BOARDING) { inclusive = true }
                }
            }

            NotificationsScreen(
                onSkipClick = completeRegistrationAndNavigate,
                onNotifyClick = completeRegistrationAndNavigate
            )
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}