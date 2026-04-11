package com.example.purchapp.data.repositories

import com.example.purchapp.domain.entities.Purchase
import com.example.purchapp.domain.repositories.PurchaseHistoryRepository

class PurchaseHistoryRepositoryImpl : PurchaseHistoryRepository {
    override suspend fun getAllPurchasesDateAndTime(userId: String): Result<List<Long>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPurchaseDetails(
        userId: String,
        purchaseId: String
    ): Result<Purchase> {
        TODO("Not yet implemented")
    }
}