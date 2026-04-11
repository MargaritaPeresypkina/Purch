package com.example.purchapp.data.remote.auth

import com.example.purchapp.domain.entities.User
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
    ): User {
            val result = firebaseAuth.createUserWithEmailAndPassword(login, password).await()
            val firebaseUser = result.user ?: throw Exception("User creation failed")

            firebaseUser.updateProfile(
                userProfileChangeRequest {
                    displayName = fullName
                }
            ).await()
            return User(id = firebaseUser.uid, fullName = firebaseUser.displayName ?: fullName)
    }

    suspend fun login(
        login: String,
        password: String
    ): User {
        val result = firebaseAuth.signInWithEmailAndPassword(login, password).await()
        val firebaseUser = result.user ?: throw Exception("Login failed")
        return User(id = firebaseUser.uid, fullName = firebaseUser.displayName ?: "Unknown")
    }

    fun getCurrentUser(): User? {
        val firebaseUser = firebaseAuth.currentUser ?: return null
        return User(
            id = firebaseUser.uid,
            fullName = firebaseUser.displayName ?: ""
        )
    }

    fun getCurrentUserId(): String? = firebaseAuth.currentUser?.uid

    fun logout() {
        firebaseAuth.signOut()
    }
}