package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.BasketRepository
import javax.inject.Inject

class PayForBasketItemsUseCase @Inject constructor(
    private val basketRepository: BasketRepository
) {
    suspend operator fun invoke(userId: String): Result<Int> {
        return basketRepository.payForBasketItems(userId = userId)
    }
}