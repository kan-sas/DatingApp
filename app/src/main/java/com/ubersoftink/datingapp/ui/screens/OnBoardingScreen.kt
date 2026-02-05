package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onCreateAccountButton: () -> Unit,
    onAuthButton: () -> Unit,
    catViewModel: CatsListViewModel = hiltViewModel()
){
    val catListUi = catViewModel.uiState.collectAsState()

    Surface(color = MaterialTheme.colorScheme.surface) {
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            if (catListUi.value.isLoading) {
                LoadingScreen()
            }else if (catListUi.value.errorMessage != null) {
                ErrorScreen(catListUi.value.errorMessage.toString())
            } else {
                OnBoardingContent(
                    catResponses = catListUi.value.catsList,
                    onCreateAccountButton = onCreateAccountButton,
                    onAuthButton = onAuthButton,
                )
            }
        }
    }
}