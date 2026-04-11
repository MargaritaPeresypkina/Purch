package com.example.purchapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.purchapp.data.local.dao.PackDao
import com.example.purchapp.data.local.database.PurchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    companion object {

        @Provides
        @Singleton
        fun providePurchDatabase(
            @ApplicationContext context: Context
        ): PurchDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = PurchDatabase::class.java,
                name = "purch.db"
            ).fallbackToDestructiveMigration(true).build()
        }

        @Provides
        @Singleton
        fun providePackDao(
            database: PurchDatabase
        ): PackDao = database.packDao()
    }
}