package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.BasketRepository

class AddPackToBasketUseCase(
    private val basketRepository: BasketRepository
) {
    suspend operator fun invoke(userId: String, packId: String, quantity: Int): Result<Unit> {
        return basketRepository.addPackToBasket(userId = userId, packId = packId, quantity = quantity)
    }
}