package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsListViewModel @Inject constructor(
    private val catRepo: CatsRepository
): ViewModel() {
    private val _uiState = MutableLiveData<NetworkResult<List<CatResponse>>>()
    val uiState: LiveData<NetworkResult<List<CatResponse>>>
        get() = _uiState

    init{
        getImages()
    }

    private fun getImages(){
        viewModelScope.launch {
            catRepo.getImages().let {
                _uiState.value = it
            }
        }
    }
}