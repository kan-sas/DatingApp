package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.CatResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ClientApiService {

    @GET("images/search?limit=32")
    suspend fun getImages(): Response<List<CatResponse>>
}