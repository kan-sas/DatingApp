package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.network.ClientApiService
import com.ubersoftink.datingapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val clientApiService: ClientApiService
): CatsRepository {

    override fun getImages(): Flow<NetworkResult<List<CatResponse>>> = flow {
        kotlin.runCatching {
            clientApiService.getImages()
        }
            .onSuccess { emit(NetworkResult.Success(it)) }
            .onFailure { emit(NetworkResult.Error(data = null, message = "Api call failed!")) }
    }
}