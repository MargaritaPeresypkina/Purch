package com.example.purchapp.data.remote.firestore.dto

data class BasketDto(
    val items: List<BasketItemDto> = emptyList()
)
