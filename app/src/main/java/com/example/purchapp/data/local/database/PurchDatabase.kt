package com.example.purchapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.purchapp.data.local.dao.PackDao
import com.example.purchapp.data.local.db_models.BarcodeDbModel
import com.example.purchapp.data.local.db_models.PackDbModel
import com.example.purchapp.data.local.db_models.PackPriceDbModel
import com.example.purchapp.data.local.db_models.UnitDbModel

@Database(
    entities = [
        BarcodeDbModel::class,
        UnitDbModel::class,
        PackDbModel::class,
        PackPriceDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PurchDatabase: RoomDatabase() {
    abstract fun packDao(): PackDao
}