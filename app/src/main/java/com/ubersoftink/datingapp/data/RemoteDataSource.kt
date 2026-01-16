package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.network.ClientApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val clientApiService: ClientApiService
) {
    suspend fun getPhotos() = clientApiService.getImages()
}