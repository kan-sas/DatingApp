package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse
import retrofit2.http.GET

private const val IMAGES_SEARCH = "images/search?limit=32"

interface ClientApiService {

    @GET(IMAGES_SEARCH)
    suspend fun getImages(): List<CatResponse>
}