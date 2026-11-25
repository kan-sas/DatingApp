package com.ubersoftink.datingapp.network

interface AuthService {
    suspend fun login(): TokenPair
    suspend fun register()
    suspend fun refresh(): TokenPair

}