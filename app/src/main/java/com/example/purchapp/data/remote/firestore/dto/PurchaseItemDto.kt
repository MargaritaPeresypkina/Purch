package com.example.purchapp.data.remote.firestore.dto

data class PurchaseItemDto(
    val packName: String,
    val quantity: Int,
    val unitName: String,
    val type: Int,
    val packQuant: Int,
    val price: Int,
    val barcode: String
)
