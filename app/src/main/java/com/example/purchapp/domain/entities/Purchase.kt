package com.example.purchapp.domain.entities

data class Purchase(
    val id: String,
    val amountSpent: Int,
    val timestamp: Long,
    val purchases: List<BasketItem>
)
