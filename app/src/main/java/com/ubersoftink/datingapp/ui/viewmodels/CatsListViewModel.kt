package com.ubersoftink.datingapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.CatsRepositoryImpl
import com.ubersoftink.datingapp.data.models.CatResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CatsListViewModel @Inject constructor(
    private val catRepo: CatsRepository
): ViewModel() {
    val catListUi: StateFlow<CatListUi> = catRepo.getImages()
        .map { CatListUi(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = CatListUi()
        )
}

data class CatListUi(val catList: List<CatResponse> = listOf())