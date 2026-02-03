package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel

@Composable
fun CatsListScreen(
    modifier: Modifier = Modifier,
    catViewModel: CatsListViewModel = hiltViewModel()
){
    val catListUi = catViewModel.uiState.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if(catListUi.value.isLoading){
            LoadingScreen()
        }
        if(catListUi.value.errorMessage != null){
            ErrorScreen(catListUi.value.errorMessage.toString())
        }else{
            CatsListContent(catResponses = catListUi.value.catsList)
        }
    }
}