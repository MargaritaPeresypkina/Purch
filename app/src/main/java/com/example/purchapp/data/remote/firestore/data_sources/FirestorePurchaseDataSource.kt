package com.example.purchapp.data.remote.firestore.data_sources

import com.example.purchapp.data.remote.firestore.dto.PurchaseDto
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestorePurchaseDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    private val usersCollection = firestore.collection("users")

    suspend fun addPurchase(
        userId: String,
        purchaseDto: PurchaseDto
    ): Result<String> {
        if (userId.isBlank()) {
            return Result.failure(Exception("User ID is empty"))
        }

        return try {
            val purchasesCollection = usersCollection
                .document(userId)
                .collection("purchases")

            val documentReference = purchasesCollection.add(purchaseDto).await()

            val purchaseId = documentReference.id

            Result.success(purchaseId)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPurchaseHistory(userId: String): List<Pair<String, PurchaseDto>> {
        if (userId.isBlank()) return emptyList()

        return try {
            val snapshot = usersCollection
                .document(userId)
                .collection("purchases")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .get()
                .await()

            snapshot.documents.mapNotNull { doc ->
                doc.toObject(PurchaseDto::class.java)?.let { dto ->
                    doc.id to dto
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getPurchaseById(userId: String, purchaseId: String): Pair<String, PurchaseDto>? {
        if (userId.isBlank() || purchaseId.isBlank()) return null

        return try {
            val document = usersCollection
                .document(userId)
                .collection("purchases")
                .document(purchaseId)
                .get()
                .await()

            document.toObject(PurchaseDto::class.java)?.let { dto ->
                document.id to dto
            }
        } catch (e: Exception) {
            null
        }
    }
}