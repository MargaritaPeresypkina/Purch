package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        password: String,
        login: String
    ): Result<Unit>{
        return authRepository.login(password = password, login = login)
    }
}