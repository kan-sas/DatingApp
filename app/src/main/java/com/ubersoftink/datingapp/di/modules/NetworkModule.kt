package com.ubersoftink.datingapp.di.modules

import com.ubersoftink.datingapp.network.CatApiService
import com.ubersoftink.datingapp.network.CatApiServiceImpl
import com.ubersoftink.datingapp.network.AuthService
import com.ubersoftink.datingapp.network.AuthServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindCatServiceImpl(
        catsServiceImpl: CatApiServiceImpl
    ): CatApiService


    @Binds
    abstract fun bindAuthServiceImpl(
        authServiceImpl: AuthServiceImpl
    ): AuthService
}