package com.example.purchapp.data.repositories

import com.example.purchapp.domain.entities.Pack
import com.example.purchapp.domain.repositories.PackRepository

class PackRepositoryImpl : PackRepository {
    override suspend fun getAllPacks(): Result<List<Pack>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPack(packId: String): Result<Pack> {
        TODO("Not yet implemented")
    }

    override suspend fun addPackToBasket(
        userId: String,
        packId: String,
        quantity: Int
    ): Result<Unit> {
        TODO("Not yet implemented")
    }
}