package com.example.purchapp.data.remote.firestore.dto

data class PurchaseDto(
    val amountSpent: Int,
    val timestamp: Long,
    val items: List<PurchaseItemDto>
)
