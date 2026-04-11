package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.Purchase
import com.example.purchapp.domain.repositories.PurchaseHistoryRepository

class GetPurchaseDetailsUseCase(
    private val purchaseHistoryRepository: PurchaseHistoryRepository
) {
    suspend operator fun invoke(userId: String, purchaseId: String): Result<Purchase> {
        return purchaseHistoryRepository.getPurchaseDetails(userId = userId, purchaseId = purchaseId)
    }
}