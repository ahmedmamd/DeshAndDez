package com.deshAndDez.data.repositories.settings

import kotlinx.coroutines.flow.Flow


interface SettingsRepository {
    suspend fun isFirebaseTokenGuarantee(): Flow<Boolean>
    suspend fun isServerBaseUrlGuarantee(): Flow<Boolean>
    fun setFirebaseToken(value: String)
    fun getFirebaseToken(): String
    fun setLanguage(value: String)
    fun getLanguage(): String
    fun getLanguageCode(): String
    fun getUserAccessToken(): String
    fun setLanguageCode(value: String)
    fun setDeviceId(value: String)
    fun getDeviceId(): String
    fun setUserAlreadySeenIntro(isSeenIntro: Boolean)
    fun isUserAlreadySeenIntro(): Boolean
}
