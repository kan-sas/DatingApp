package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.network.ClientApiService

/**
 * Заместо Dagger Hilt
 * */
interface AppContainer{
    val remoteDataSource: RemoteDataSource
    val catsRepository: CatsRepository
}

class NetworkContainer: AppContainer {
    override val remoteDataSource: RemoteDataSource by lazy{
        RemoteDataSource(ClientApiService.create())
    }
    override val catsRepository: CatsRepository by lazy{
        CatsRepository(remoteDataSource)
    }
}