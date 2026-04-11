package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.User
import com.example.purchapp.domain.repositories.AuthRepository

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Result<User> {
        return authRepository.getCurrentUser()
    }
}