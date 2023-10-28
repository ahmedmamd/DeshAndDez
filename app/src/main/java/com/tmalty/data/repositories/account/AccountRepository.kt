package com.tmalty.data.repositories.account

import com.tmalty.data.models.VerifySession
import com.tmalty.data.models.account.Profile
import com.tmalty.data.models.account.UserSession
import com.tmalty.data.models.account.apibody.ForgotPasswordResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface AccountRepository {
    suspend fun login(email: String, password: String): Flow<UserSession>
    suspend fun changePassword(currentPassword: String, newPassword: String): Flow<Boolean>
    suspend fun changeEmailAddress(emailAddress: String): Flow<String>
    suspend fun confirmEmailAddressChanges(emailAddress: String,code: String): Flow<String>
    suspend fun updateProfileInfo(name: String,surname: String,shipperName: String): Flow<String>
    suspend fun validateResetPasswordCode(accountIdentity: String,passwordResetCode: String): Flow<Boolean>
    suspend fun resetPassword(
        accountIdentity: String,
        passwordResetCode: String,
        newPassword: String,
    ): Flow<Boolean>

    suspend fun forgotPassword(emailAddress: String): Flow<ForgotPasswordResponse>
    suspend fun sendJoiningRequest(
        firstName: String,
        lastName: String,
        companyName: String,
        email: String,
        phone: String
    ): Flow<String>

    suspend fun callMyProfile(): Flow<Profile>
    suspend fun verifySession(): Flow<VerifySession>
    suspend fun saveUserSession(userSession: UserSession)
    suspend fun saveUserProfile(profile: Profile)
    fun getUserProfile(): Profile
    fun isUserLogin(): Boolean
    fun logout()
    suspend fun updateAvatar(avatar: MultipartBody.Part):Flow<String>

}