package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse

interface ClientApiService {

    suspend fun getImages(): List<CatResponse>
}