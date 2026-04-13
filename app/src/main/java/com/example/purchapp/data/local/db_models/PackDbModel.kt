package com.example.purchapp.data.local.db_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.RESTRICT
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pack",
    foreignKeys = [
        ForeignKey(
        entity = UnitDbModel::class,
        parentColumns = ["id"],
        childColumns = ["unit_id"],
        onDelete = RESTRICT
        )
    ],
    indices = [Index("unit_id")]
)
data class PackDbModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("unit_id")
    val unitId: Int,
    val name: String,
    val type: Int,
    val quant: Int,
) {
    init {
        require(name.length <= 50) {
            "Name length cannot exceed 50 characters. Current length: ${name.length}"
        }
    }
}
