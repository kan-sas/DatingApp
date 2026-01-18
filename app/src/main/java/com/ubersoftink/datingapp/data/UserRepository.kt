package com.ubersoftink.datingapp.data

import com.ubersoftink.datingapp.data.models.User
import com.ubersoftink.datingapp.network.UserService

interface UserRepository{
    suspend fun getUsers(): List<User>
}

class NetworkUserRepository(
    private val userService: UserService
): UserRepository{
    override suspend fun getUsers(): List<User> = userService.getUsers()
}