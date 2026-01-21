package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse
import retrofit2.http.GET

interface ClientApiService {

    @GET("images/search?limit=32")
    suspend fun getImages(): List<CatResponse>
}