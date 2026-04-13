package com.example.purchapp.data.remote.firestore.data_sources

import com.example.purchapp.data.remote.firestore.dto.BasketItemDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreBasketDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    private val usersCollection = firestore.collection("users")

    suspend fun getBasketItems(userId: String): List<Pair<String, BasketItemDto>> {
        if (userId.isBlank()) return emptyList()

        return try {
            val snapshot = firestore
                .collection("users")
                .document(userId)
                .collection("basket")
                .get()
                .await()

            snapshot.documents.mapNotNull { doc ->
                doc.toObject(BasketItemDto::class.java)?.let { dto ->
                    doc.id to dto
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun addToBasket(
        userId: String,
        packId: Int,
        quantity: Int
    ): Result<String> {
        if (userId.isBlank()) {
            return Result.failure(Exception("User ID is empty"))
        }

        return try {
            val cartCollection = firestore
                .collection("users")
                .document(userId)
                .collection("basket")

            val existingItemQuery = cartCollection
                .whereEqualTo("pack_id", packId)
                .get()
                .await()

            if (existingItemQuery.isEmpty) {
                val newItemDto = BasketItemDto(
                    packId = packId,
                    quantity = quantity
                )
                val docRef = cartCollection.add(newItemDto).await()
                Result.success(docRef.id)
            } else {
                val existingDoc = existingItemQuery.documents.first()
                val existingItem = existingDoc.toObject(BasketItemDto::class.java)!!
                val newQuantity = existingItem.quantity + quantity

                existingDoc.reference.update("quantity", newQuantity).await()
                Result.success(existingDoc.id)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun clearBasket(userId: String): Result<Unit> {
        if (userId.isBlank()) return Result.failure(Exception("User ID is empty"))

        return try {
            val items = firestore
                .collection("users")
                .document(userId)
                .collection("basket")
                .get()
                .await()

            val batch = firestore.batch()
            items.documents.forEach { doc ->
                batch.delete(doc.reference)
            }
            batch.commit().await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}