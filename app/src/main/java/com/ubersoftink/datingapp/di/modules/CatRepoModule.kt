package com.ubersoftink.datingapp.di.modules

import com.ubersoftink.datingapp.data.CatsRepository
import com.ubersoftink.datingapp.data.CatsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CatRepoModule {

    @Binds
    abstract fun bindCatsRepository(
        catsRepositoryImpl: CatsRepositoryImpl
    ): CatsRepository
}