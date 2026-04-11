package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.repositories.PurchaseHistoryRepository
import javax.inject.Inject

class GetAllPurchasesDateAndTimeUseCase @Inject constructor(
    private val purchaseHistoryRepository: PurchaseHistoryRepository
) {
    suspend operator fun invoke(userId: String): Result<List<Long>> {
        return purchaseHistoryRepository.getAllPurchasesDateAndTime(userId = userId)
    }
}