package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse
import retrofit2.http.GET

private const val IMAGES_SEARCH = "images/search?limit=32"

interface ClientApiServiceImpl: ClientApiService {
    @GET(IMAGES_SEARCH)
    override suspend fun getImages(): List<CatResponse>

}