package com.tmalty.data.remote.firebase

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirebaseServiceImp @Inject constructor() : FirebaseService {

    private val TAG = "FirebaseServiceImp"
    private val firebaseMessaging = FirebaseMessaging.getInstance()
    private var firebaseAuth = Firebase.auth
    private val currentUser = firebaseAuth.currentUser
    private val baseUrl = "base_url"

    private val firebaseDatabaseReference = FirebaseDatabase.getInstance().reference
    private val serverBaseUrlReference = firebaseDatabaseReference.child(baseUrl)

    val email = "systemwasaal@gmail.com"
    val password = "123456789"

    override fun getSystemEmail() = email

    override fun getSystemPassword() = password
    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ) = callbackFlow {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    trySend(true)
                    close()
                } else {
                    it.exception?.let {
                        close(it)
                    }
                }
            }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) = callbackFlow {
        if (firebaseAuth.currentUser != null) {
            Log.e(TAG, "firebaseAuth.currentUser")
            trySend(true)
            close()
            return@callbackFlow
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.e(TAG, "signInWithEmailAndPassword: True")
                if (it.isSuccessful) {
                    trySend(true)
                }
            }
        awaitClose { channel.close() }
    }

    override suspend fun gettingServerBaseUrl() = callbackFlow {
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.e(TAG, "onDataChange: True")
                snapshot.getValue(String::class.java)?.let {
                    Log.e(TAG, "Url $it")
                    trySend(it)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "onCancelled: True")
            }
        }
        serverBaseUrlReference.addListenerForSingleValueEvent(valueEventListener)
        awaitClose {
            serverBaseUrlReference.removeEventListener(valueEventListener)
            channel.close()
        }
    }

    override suspend fun gettingFirebaseMessagingToken() = callbackFlow {
        val listener = OnCompleteListener<String> { it ->
            if (it.isSuccessful) {
                it.result?.let { token ->
                    Log.e(TAG,"Token $token")
                    trySend(token)
                }
            }
        }
        firebaseMessaging.token.addOnCompleteListener(listener)
        awaitClose { channel.close() }
    }
}