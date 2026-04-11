package com.example.purchapp.domain.repositories

import com.example.purchapp.domain.entities.BasketItem

interface BasketRepository {

    suspend fun getAllBasketItems(userId: String): Result<List<BasketItem>>

    suspend fun payForBasketItems(userId: String): Result<Int>

}