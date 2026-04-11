package com.example.purchapp.data.repositories

import com.example.purchapp.domain.entities.BasketItem
import com.example.purchapp.domain.repositories.BasketRepository

class BasketRepositoryImpl : BasketRepository {
    override suspend fun getAllBasketItems(userId: String): Result<List<BasketItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun payForBasketItems(userId: String): Result<Int> {
        TODO("Not yet implemented")
    }
}