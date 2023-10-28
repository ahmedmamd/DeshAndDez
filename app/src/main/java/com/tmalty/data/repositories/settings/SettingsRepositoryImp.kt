package com.tmalty.data.repositories.settings

import android.util.Log
import com.tmalty.commons.helpers.Constants
import com.tmalty.data.models.account.UserSession
import com.tmalty.data.preference.SharedPreferencesKeys
import com.tmalty.data.preference.SharedPreferencesManager
import com.tmalty.data.remote.firebase.FirebaseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsRepositoryImp @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val firebaseService: FirebaseService
) :
    SettingsRepository {
    private val TAG = "SettingsRepositoryImp"
    override suspend fun isServerBaseUrlGuarantee() = callbackFlow {
        var isSignedIn = false
        val loginJob = launch {
            firebaseService.signInWithEmailAndPassword(
                firebaseService.getSystemEmail(),
                firebaseService.getSystemPassword()
            ).collectLatest {
                isSignedIn = it
            }
        }
        loginJob.join()
        if (isSignedIn)
            firebaseService.gettingServerBaseUrl().collect {
                it?.let {
                    Log.e(TAG, "Constants.Public.SERVER_BASE_URL_$it")
                    Constants.Public.SERVER_BASE_URL = it
                    trySend(true)
                }
            }
        awaitClose { channel.close() }
    }.flowOn(Dispatchers.IO)

    override suspend fun isFirebaseTokenGuarantee() = callbackFlow {
        var token = sharedPreferencesManager.get(SharedPreferencesKeys.FIREBASE_TOKEN, "")
        if (token.isNotEmpty()) {
            Log.e(TAG, "Token Not Empty $token")
            send(true)
        } else {
            firebaseService.gettingFirebaseMessagingToken().collectLatest {
                Log.e(TAG, "Token $token")
                token = it
                sharedPreferencesManager.put(SharedPreferencesKeys.FIREBASE_TOKEN, token)
                trySend(true)
            }
        }
        awaitClose { channel.close() }
    }.flowOn(Dispatchers.IO)


    override fun setFirebaseToken(value: String) {
        sharedPreferencesManager.put(SharedPreferencesKeys.FIREBASE_TOKEN, value)
    }

    override fun getFirebaseToken() =
        sharedPreferencesManager.get(SharedPreferencesKeys.FIREBASE_TOKEN, "")

    override fun setLanguage(value: String) {
        sharedPreferencesManager.put(SharedPreferencesKeys.LANGUAGE, value)
        when (value) {
            SharedPreferencesKeys.EN -> {
                setLanguageCode(SharedPreferencesKeys.EN_US)
            }

            SharedPreferencesKeys.AR -> {
                setLanguageCode(SharedPreferencesKeys.AR_EG)
            }
        }
    }

    override fun getLanguage() =
        sharedPreferencesManager.get(SharedPreferencesKeys.LANGUAGE, SharedPreferencesKeys.EN)


    override fun setLanguageCode(value: String) {
        sharedPreferencesManager.put(
            SharedPreferencesKeys.LANGUAGE_CODE,
            value
        )
    }

    override fun getLanguageCode() =
        sharedPreferencesManager.get(
            SharedPreferencesKeys.LANGUAGE_CODE,
            SharedPreferencesKeys.EN_US
        )


    override fun getUserAccessToken() =
        sharedPreferencesManager.getObject(
            SharedPreferencesKeys.USER_SESSION,
            UserSession()
        ).accessToken ?: ""


    override fun setDeviceId(value: String) {
        sharedPreferencesManager.put(SharedPreferencesKeys.DEVICE_ID, value)
    }

    override fun getDeviceId() =
        sharedPreferencesManager.get(SharedPreferencesKeys.DEVICE_ID, "")

    override fun setUserAlreadySeenIntro(isSeenIntro: Boolean) {
        sharedPreferencesManager.put(SharedPreferencesKeys.USER_SEEN_INTRO, isSeenIntro)
    }

    override fun isUserAlreadySeenIntro() =
        sharedPreferencesManager.get(SharedPreferencesKeys.USER_SEEN_INTRO, false)
}