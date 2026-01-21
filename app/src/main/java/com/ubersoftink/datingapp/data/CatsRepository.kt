package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.CatResponse
import kotlinx.coroutines.flow.Flow

interface CatsRepository {
    fun getImages(): Flow<List<CatResponse>>
}