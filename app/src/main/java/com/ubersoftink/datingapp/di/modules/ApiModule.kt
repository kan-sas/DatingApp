package com.ubersoftink.datingapp.di.modules

import androidx.core.os.BuildCompat
import com.google.gson.internal.GsonBuildConfig
import com.ubersoftink.datingapp.network.ClientApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private  const val BASE_URL = "https://api.thecatapi.com/v1/"

    private const val API_KEY = "live_2LuKx38zGShWPwKTWWYT9Oem2dScbYd7zmmjc2tVNJCp7c53Rjzcj2y5Jx0e6ft7"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor{ chain ->
                val request = chain.request().newBuilder().addHeader("x-api-key", API_KEY).build()
                chain.proceed(request)
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesCatService(retrofit: Retrofit) = retrofit.create(ClientApiService::class.java)
}