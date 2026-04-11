package com.example.purchapp.domain.repositories

import com.example.purchapp.domain.entities.Purchase

interface PurchaseHistoryRepository {
    suspend fun getAllPurchasesDateAndTime(userId: String): Result<List<Long>>

    suspend fun getPurchaseDetails(userId: String, purchaseId: String): Result<Purchase>

}