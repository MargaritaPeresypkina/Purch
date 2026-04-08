package com.example.purchapp.domain.entities

data class Pack(
    val id: Int,
    val unitId: Int,
    val name: String,
    val type: ProductType,
    val quant: Int
)

enum class ProductType {
    PIECE,
    WEIGHT
}