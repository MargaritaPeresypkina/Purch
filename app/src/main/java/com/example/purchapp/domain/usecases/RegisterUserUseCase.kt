package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.AuthRepository

class RegisterUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        login: String,
        password: String,
        fullName: String
    ): Result<Unit> {
        return authRepository.register(fullName = fullName, password = password, login = login)
    }
}