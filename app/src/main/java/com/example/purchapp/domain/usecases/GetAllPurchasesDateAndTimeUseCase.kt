package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.PurchaseHistoryRepository

class GetAllPurchasesDateAndTimeUseCase(
    private val purchaseHistoryRepository: PurchaseHistoryRepository
) {
    suspend operator fun invoke(userId: String): Result<List<Long>> {
        return purchaseHistoryRepository.getAllPurchasesDateAndTime(userId = userId)
    }
}