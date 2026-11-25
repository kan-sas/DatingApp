package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse

interface CatApiService {

    suspend fun getImages(): List<CatResponse>
}