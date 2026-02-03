package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsListViewModel @Inject constructor(
    private val catRepo: CatsRepository
): ViewModel() {

    private var _uiState = MutableStateFlow(CatListUiState())
    val uiState = _uiState.asStateFlow()

    init{
        loadCats()
    }

    fun loadCats(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            catRepo.getImages().collect { result ->
                when(result){
                    is NetworkResult.Success -> {
                        _uiState.update {
                            it.copy(
                                catsList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }
                    is NetworkResult.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                catsList = emptyList(),
                                errorMessage = result.message
                            )
                        }
                    }
                    else -> {
                        _uiState.update {
                            it.copy(isLoading = true)
                        }
                    }
                }
            }
        }
    }
}