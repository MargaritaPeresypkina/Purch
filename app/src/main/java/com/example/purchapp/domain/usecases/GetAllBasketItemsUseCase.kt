package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.BasketItem
import com.example.purchapp.domain.repositories.BasketRepository
import javax.inject.Inject

class GetAllBasketItemsUseCase @Inject constructor(
    private val basketRepository: BasketRepository
) {
    suspend operator fun invoke(userId: String): Result<List<BasketItem>> {
        return basketRepository.getAllBasketItems(userId = userId)
    }
}