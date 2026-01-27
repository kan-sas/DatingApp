package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel
import com.ubersoftink.datingapp.utils.NetworkResult

@Composable
fun CatsListScreen(
    modifier: Modifier = Modifier,
    catViewModel: CatsListViewModel = hiltViewModel()
){
    val catListUi = catViewModel.catListUi.collectAsState().value

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when (catListUi) {
            is NetworkResult.Success -> {
                CatsListContent(catResponses = catListUi.data ?: listOf())
            }

            is NetworkResult.Error -> {
                ErrorScreen(catListUi.message ?: "Unknown error!\nSomething went wrong :-(")
            }

            else -> {
                LoadingScreen()
            }
        }
    }
}