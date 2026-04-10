package com.example.purchapp.domain.entities

data class Pack(
    val id: Int,
    val unit: Unit,
    val name: String,
    val type: ProductType,
    val quant: Int,
    val packPrice: PackPrice,
    val barcode: Barcode
)

enum class ProductType(val value: Int) {
    PIECE(0),
    WEIGHT(1)
}