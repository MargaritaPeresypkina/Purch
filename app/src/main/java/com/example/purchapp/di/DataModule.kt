package com.example.purchapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.purchapp.data.local.dao.PackDao
import com.example.purchapp.data.local.database.PurchDatabase
import com.example.purchapp.data.repositories.AuthRepositoryImpl
import com.example.purchapp.data.repositories.BasketRepositoryImpl
import com.example.purchapp.data.repositories.PackRepositoryImpl
import com.example.purchapp.data.repositories.PurchaseHistoryRepositoryImpl
import com.example.purchapp.domain.repositories.AuthRepository
import com.example.purchapp.domain.repositories.BasketRepository
import com.example.purchapp.domain.repositories.PackRepository
import com.example.purchapp.domain.repositories.PurchaseHistoryRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindPackRepository(
        impl: PackRepositoryImpl
    ): PackRepository

    @Singleton
    @Binds
    fun bindBasketRepository(
        impl: BasketRepositoryImpl
    ): BasketRepository

    @Singleton
    @Binds
    fun bindPurchaseHistoryRepository(
        impl: PurchaseHistoryRepositoryImpl
    ): PurchaseHistoryRepository

    @Singleton
    @Binds
    fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

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

        @Provides
        @Singleton
        fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

        @Provides
        @Singleton
        fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()
    }
}