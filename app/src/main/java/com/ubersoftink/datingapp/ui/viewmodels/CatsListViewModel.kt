package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CatsListViewModel @Inject constructor(
    private val catRepo: CatsRepository
): ViewModel() {
    val catListUi: StateFlow<NetworkResult<List<CatResponse>>> = catRepo.getImages()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = NetworkResult.Loading()
        )
}