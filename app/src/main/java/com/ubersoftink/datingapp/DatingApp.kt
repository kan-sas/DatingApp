package com.ubersoftink.datingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ubersoftink.datingapp.ui.navigation.DatingNavHost

/*enum class DatingAppScreens{
    StartScreen,
    Home,
    SignUp,
    Number,
    Code,   //verification code
    ProfileDetails,
    Calendar,
    Sex,
    Passions,
    Friends,
    Notification,
    MainScreen,
    Match,
    Matches,
    Messages,
    Chat,
    Stories,
    Profile,
    PhotoFullScreen,
    *//* пока не понял, будет ли filters часть экрана или отдельно выплывающее окно
    Filters,
     *//*
}*/

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