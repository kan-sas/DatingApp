package com.ubersoftink.datingapp.ui.viewmodels

import com.ubersoftink.datingapp.data.models.CatResponse

data class CatListUiState(
    val catsList: List<CatResponse> = listOf(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)