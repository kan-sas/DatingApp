package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CatsRepository {
    fun getImages(): Flow<NetworkResult<List<CatResponse>>>
}