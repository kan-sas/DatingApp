package com.ubersoftink.datingapp.ui.navigation

/**
 * Интерфейс навигации по приложению через навигационный граф
 * */
interface NavigationDestination {
    val route: String
    val titleRes: Int
}