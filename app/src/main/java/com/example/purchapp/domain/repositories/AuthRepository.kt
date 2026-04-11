package com.example.purchapp.domain.repositories

import com.example.purchapp.domain.entities.User

interface AuthRepository {
    suspend fun register(
        fullName: String,
        login: String,
        password: String
    ): Result<User>

    suspend fun login(
        login: String,
        password: String
    ): Result<User>

    fun logout(): Result<Unit>

    fun getCurrentUser(): Result<User?>

    fun getCurrentUserId(): Result<String?>
}