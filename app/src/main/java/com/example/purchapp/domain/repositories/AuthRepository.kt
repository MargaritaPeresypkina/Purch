package com.example.purchapp.domain.repositories

import com.example.purchapp.domain.models.User

interface AuthRepository {
    suspend fun register(
        fullName: String,
        login: String,
        password: String
    ): Result<Unit>

    suspend fun login(
        login: String,
        password: String
    ): Result<Unit>

    suspend fun logout(): Result<Unit>

    fun getCurrentUser(): Result<User>
}