package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.PackRepository

class AddPackToBasketUseCase(
    private val packRepository: PackRepository
) {
    suspend operator fun invoke(userId: String, packId: String, quantity: Int): Result<Unit> {
        return packRepository.addPackToBasket(userId = userId, packId = packId, quantity = quantity)
    }
}