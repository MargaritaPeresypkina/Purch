package com.example.purchapp.data.remote.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend fun register(
        fullName: String,
        login: String,
        password: String
    ): Result<Unit> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(login, password).await()
            val firebaseUser = authResult.user ?: throw Exception("User creation failed")

            firebaseUser.updateProfile(
                userProfileChangeRequest {
                    displayName = fullName
                }
            ).await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getCurrentUserId(): String? = firebaseAuth.currentUser?.uid

    fun isLoggedIn(): Boolean = firebaseAuth.currentUser != null

    fun logout() {
        firebaseAuth.signOut()
    }
}