package com.example.purchapp.data.local.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "unit"
)
data class UnitDbModel(
    @PrimaryKey
    val id: Int,
    val name: String
) {
    init {
        require(name.length <= 50) {
            "Name length cannot exceed 50 characters. Current length: ${name.length}"
        }
    }
}
