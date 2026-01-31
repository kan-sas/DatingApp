package com.ubersoftink.datingapp.di.modules

import com.ubersoftink.datingapp.network.ClientApiService
import com.ubersoftink.datingapp.network.ClientApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindClientServiceImpl(
        catsServiceImpl: ClientApiServiceImpl
    ): ClientApiService
}