package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ubersoftink.datingapp.DatingApplication
import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.NetworkResult
import kotlinx.coroutines.launch

class CatsListViewModel(
    private val catRepo: CatsRepository
): ViewModel() {
    private val _uiState = MutableLiveData<NetworkResult<List<CatResponse>>>()
    val uiState: LiveData<NetworkResult<List<CatResponse>>>
        get() = _uiState

    init{
        getTwelveImages()
    }

    private  fun getTwelveImages(){
        viewModelScope.launch {
            catRepo.getImages().let {
                _uiState.value = it
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DatingApplication)
                val catsRepository = application.container.catsRepository
                CatsListViewModel(catsRepository)
            }
        }
    }
}