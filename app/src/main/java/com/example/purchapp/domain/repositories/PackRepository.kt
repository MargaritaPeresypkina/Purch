package com.example.purchapp.domain.repositories

import com.example.purchapp.domain.entities.Pack

interface PackRepository {

    suspend fun getAllPacks(): Result<List<Pack>>

    suspend fun getPack(packId: String): Result<Pack>

}