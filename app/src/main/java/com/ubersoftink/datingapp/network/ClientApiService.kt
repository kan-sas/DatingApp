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
    companion object{
        private  const val BASE_URL = "https://api.thecatapi.com/v1/"
        private const val API_KEY = "live_2LuKx38zGShWPwKTWWYT9Oem2dScbYd7zmmjc2tVNJCp7c53Rjzcj2y5Jx0e6ft7"

        fun create(): ClientApiService {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor{ chain ->
                    val request = chain.request().newBuilder().addHeader("x-api-key", API_KEY).build()
                    chain.proceed(request)
                }
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ClientApiService::class.java)
        }
    }
}