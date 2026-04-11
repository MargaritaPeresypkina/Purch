package com.example.purchapp.data.local.db_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pack_price",
    foreignKeys = [ForeignKey(
        entity = PackDbModel::class,
        parentColumns = ["id"],
        childColumns = ["pack_id"],
        onDelete = CASCADE
    )],
    indices = [Index("pack_id", unique = true)]
)
data class PackPriceDbModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("pack_id")
    val packId: Int,
    val price: Int,
    val bonus: Int
)
