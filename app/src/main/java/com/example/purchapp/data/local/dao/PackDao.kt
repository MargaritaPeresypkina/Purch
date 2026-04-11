package com.example.purchapp.data.local.dao

import androidx.room.Query
import androidx.room.Transaction
import com.example.purchapp.data.local.models.PackWithContentDbModel

interface PackDao {

    @Transaction
    @Query("SELECT * FROM pack")
    suspend fun getAllPacks(): List<PackWithContentDbModel>

    @Transaction
    @Query("SELECT * FROM pack WHERE id = :packId")
    suspend fun getPack(packId: Int): PackWithContentDbModel
}