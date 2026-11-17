package com.ubersoftink.datingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.ubersoftink.datingapp.ui.viewmodels.CatsListViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    catViewModel: CatsListViewModel = hiltViewModel()
){
    val catListUi = catViewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        when {
            catListUi.value.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primaryContainer)
                }
            }
            catListUi.value.errorMessage != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = catListUi.value.errorMessage.toString(), color = Color.Red)
                }
            }
            else -> {
                // Передаем список котов в новый UI-компонент карточки свайпов
                MainScreenContent(catsList = catListUi.value.catsList, onBackClick = {})
            }
        }
    }
}