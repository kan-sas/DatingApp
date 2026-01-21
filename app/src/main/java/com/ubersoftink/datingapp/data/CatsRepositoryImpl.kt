package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.network.ClientApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val clientApiService: ClientApiService
): CatsRepository{
    override fun getImages(): Flow<List<CatResponse>> = flow{
        emit(clientApiService.getImages())
    }
}