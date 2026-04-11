package com.example.purchapp.data.remote.firestore.dto

data class BasketItemDto(
    val packId: Int,
    val quantity: Int,
    val addedAt: Long = System.currentTimeMillis()
)
