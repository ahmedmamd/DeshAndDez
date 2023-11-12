package com.deshAndDez.data.remote.firebase

import kotlinx.coroutines.flow.Flow

interface FirebaseService {
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Boolean>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Boolean>
    suspend fun gettingServerBaseUrl(): Flow<String>
    fun getSystemEmail(): String
    fun getSystemPassword(): String
    suspend fun gettingFirebaseMessagingToken(): Flow<String>
}