package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.AuthRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
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