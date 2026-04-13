package com.example.purchapp.data.repositories

import com.example.purchapp.domain.entities.User
import com.example.purchapp.domain.repositories.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(
        fullName: String,
        login: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun login(
        login: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override fun logout(): Result<Unit> {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): Result<User?> {
        TODO("Not yet implemented")
    }
}