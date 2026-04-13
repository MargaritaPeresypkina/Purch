package com.example.purchapp.data.local.db_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "barcode",
    foreignKeys = [ForeignKey(
        entity = PackDbModel::class,
        parentColumns = ["id"],
        childColumns = ["pack_id"],
        onDelete = CASCADE
    )],
    indices = [
        Index("pack_id", unique = true),
        Index("body", unique = true)
    ]
)
data class BarcodeDbModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("pack_id")
    val packId: Int,
    val body: String
) {
    init {
        require(body.length <= 30) {
            "Body length cannot exceed 30 characters. Current length: ${body.length}"
        }
    }
}
