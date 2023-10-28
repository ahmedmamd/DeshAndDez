package com.tmalty.data.repositories.account

import com.tmalty.commons.extensions.transformResponseData
import com.tmalty.commons.helpers.Constants
import com.tmalty.data.models.account.Profile
import com.tmalty.data.models.account.UserSession
import com.tmalty.data.models.account.apibody.ChangePasswordBody
import com.tmalty.data.models.account.apibody.ResetPasswordBody
import com.tmalty.data.models.account.apibody.ValidateResetPasswordCodeBody
import com.tmalty.data.preference.SharedPreferencesKeys
import com.tmalty.data.preference.SharedPreferencesManager
import com.tmalty.data.remote.endpoints.AccountService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import okhttp3.MultipartBody
import javax.inject.Inject


class AccountRepositoryImp @Inject constructor(
    private val accountService: AccountService,
    private val sharedPreferencesManager: SharedPreferencesManager
) :
    AccountRepository {
    override suspend fun login(email: String, password: String) =
        flow {
            val hashMap = HashMap<String, Any>()
            hashMap[Constants.ApiMappingKey.USERNAME_OR_EMAIL_ADDRESS] = email
            hashMap[Constants.ApiMappingKey.PASSWORD] = password
            emit(accountService.authenticate(hashMap))
        }.transformResponseData {
            emit(it)
        }.onEach { userSession ->
            saveUserSession(userSession)
        }.flowOn(Dispatchers.IO)

    override suspend fun changePassword(
        currentPassword: String,
        newPassword: String
    ) = flow {
        val changePasswordCodeBody = ChangePasswordBody(currentPassword, newPassword)
        emit(accountService.changePassword(changePasswordCodeBody))
    }.transformResponseData { emit(it) }

    override suspend fun changeEmailAddress(emailAddress: String) =
        flow {
            val hashMap = HashMap<String, Any>()
            hashMap[Constants.ApiMappingKey.EMAIL_ADDRESS] = emailAddress
            emit(accountService.changeEmailAddress(hashMap))
        }.transformResponseData { emit(it) }


    override suspend fun updateAvatar(avatar: MultipartBody.Part) = flow {
        emit(accountService.updateAvatar(avatar))
    }.transformResponseData {
        emit(it)
    }

    override suspend fun confirmEmailAddressChanges(
        emailAddress: String,
        code: String
    ) =
        flow {
            val hashMap = HashMap<String, Any>()
            hashMap[Constants.ApiMappingKey.EMAIL_ADDRESS] = emailAddress
            hashMap[Constants.ApiMappingKey.CODE] = code
            emit(accountService.confirmEmailAddressChanges(hashMap))
        }.transformResponseData { emit(it) }


    override suspend fun updateProfileInfo(
        name: String,
        surname: String,
        shipperName: String
    ) =
        flow {
            val hashMap = HashMap<String, Any>()
            hashMap[Constants.ApiMappingKey.NAME] = name
            hashMap[Constants.ApiMappingKey.SURNAME] = surname
            hashMap[Constants.ApiMappingKey.SHIPPER_NAME] = shipperName
            emit(accountService.updateProfileInfo(hashMap))
        }.transformResponseData { emit(it) }

    override suspend fun validateResetPasswordCode(
        accountIdentity: String,
        passwordResetCode: String
    ) = flow {
        val validateResetPasswordCodeBody =
            ValidateResetPasswordCodeBody(accountIdentity, passwordResetCode)
        emit(accountService.validateResetPasswordCode(validateResetPasswordCodeBody))
    }.transformResponseData { emit(it) }

    override suspend fun resetPassword(
        accountIdentity: String,
        passwordResetCode: String,
        newPassword: String
    ) = flow {
        val resetPasswordBody =
            ResetPasswordBody(accountIdentity, passwordResetCode, newPassword)
        emit(accountService.resetPassword(resetPasswordBody))
    }.transformResponseData { emit(it) }


    override suspend fun forgotPassword(emailAddress: String) = flow {
        val hashMap = HashMap<String, String>()
        hashMap[Constants.ApiMappingKey.ACCOUNT_IDENTITY] = emailAddress
        emit(accountService.forgotPassword(hashMap))
    }.transformResponseData { emit(it) }

    override suspend fun sendJoiningRequest(
        firstName: String,
        lastName: String,
        companyName: String,
        email: String,
        phone: String
    ) = flow {
        val hashMap = HashMap<String, String>()
        hashMap[Constants.ApiMappingKey.NAME] = firstName
        hashMap[Constants.ApiMappingKey.SURNAME] = lastName
        hashMap[Constants.ApiMappingKey.SHIPPER_NAME] = companyName
        hashMap[Constants.ApiMappingKey.PHONE_NUMBER] = phone
        hashMap[Constants.ApiMappingKey.EMAIL_ADDRESS] = email
        emit(accountService.sendJoiningRequest(hashMap))
    }.transformResponseData {
        emit(it)
    }.flowOn(Dispatchers.IO)


    override suspend fun callMyProfile() =
        flow {
            emit(accountService.getProfileInfo())
        }.transformResponseData {
            emit(it)
        }.onEach {
            saveUserProfile(it)
        }.flowOn(Dispatchers.IO)

    override suspend fun saveUserProfile(profile: Profile) {
        sharedPreferencesManager.putObject(SharedPreferencesKeys.USER_PROFILE, profile)
    }

    override fun getUserProfile(): Profile {
        return sharedPreferencesManager.getObject(SharedPreferencesKeys.USER_PROFILE, Profile())
    }


    override suspend fun verifySession() =
        flow {
            emit(accountService.verifySession())
        }.transformResponseData { emit(it) }.flowOn(Dispatchers.IO)


    override suspend fun saveUserSession(userSession: UserSession) {
        sharedPreferencesManager.putObject(SharedPreferencesKeys.USER_SESSION, userSession)
    }

    override fun isUserLogin(): Boolean {
        val userSession =
            sharedPreferencesManager.getObject(SharedPreferencesKeys.USER_SESSION, UserSession())
        return userSession.accessToken?.isNotEmpty() ?: false
    }

    override fun logout() {
        sharedPreferencesManager.clearPreference(SharedPreferencesKeys.USER_SESSION)
        sharedPreferencesManager.clearPreference(SharedPreferencesKeys.USER_PROFILE)
    }


}