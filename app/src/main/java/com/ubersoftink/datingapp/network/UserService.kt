package com.ubersoftink.datingapp.network

import com.ubersoftink.datingapp.data.models.User
import retrofit2.http.GET

interface UserService {
    @GET
    suspend fun getUsers(): List<User>
}