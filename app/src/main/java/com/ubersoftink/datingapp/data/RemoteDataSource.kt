package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.network.ClientApiService

class RemoteDataSource(private val clientApiService: ClientApiService) {

    suspend fun getPhotos() = clientApiService.getImages()
}