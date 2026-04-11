package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.BasketRepository

class PayForBasketItemsUseCase(
    private val basketRepository: BasketRepository
) {
    suspend operator fun invoke(userId: String): Result<Int> {
        return basketRepository.payForBasketItems(userId = userId)
    }
}