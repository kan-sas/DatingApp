package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.CatResponse
import com.ubersoftink.datingapp.utils.BaseApiResponse
import com.ubersoftink.datingapp.utils.NetworkResult

class CatsRepository(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getImages(): NetworkResult<List<CatResponse>>{
        return saveApiCall { remoteDataSource.getPhotos() }
    }
}