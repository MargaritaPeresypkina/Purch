package com.example.purchapp.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.purchapp.data.local.db_models.PackDbModel
import com.example.purchapp.domain.entities.Barcode
import com.example.purchapp.domain.entities.PackPrice
import com.example.purchapp.domain.entities.Unit

data class PackWithContentDbModel(
    @Embedded
    val packDbModel: PackDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "pack_id"
    )
    val packPrice: PackPrice,
    @Relation(
        parentColumn = "id",
        entityColumn = "pack_id"
    )
    val barcode: Barcode,
    @Relation(
        parentColumn = "unit_id",
        entityColumn = "id"
    )
    val unit: Unit
)