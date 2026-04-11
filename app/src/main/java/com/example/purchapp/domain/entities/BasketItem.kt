package com.example.purchapp.domain.entities

data class BasketItem(
    val id: String,
    val pack: Pack,
    val quantity: Int,
    val addedAt: Long
)
