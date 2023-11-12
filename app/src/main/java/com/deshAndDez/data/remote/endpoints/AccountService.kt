package com.deshAndDez.data.remote.endpoints

import com.deshAndDez.data.models.account.Profile
import com.deshAndDez.data.models.VerifySession
import com.deshAndDez.data.models.account.apibody.ChangePasswordBody
import com.deshAndDez.data.models.account.apibody.ForgotPasswordResponse
import com.deshAndDez.data.models.account.apibody.ResetPasswordBody
import com.deshAndDez.data.models.account.UserSession
import com.deshAndDez.data.models.account.apibody.ValidateResetPasswordCodeBody
import com.deshAndDez.data.remote.EndPointResult
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

interface AccountService {
    @POST("api/TokenAuth/Authenticate")
    suspend fun authenticate(@Body req: Any?): Response<EndPointResult<UserSession>>

    @POST("api/services/app/ShipperJoiningRequest/Request")
    suspend fun sendJoiningRequest(@Body req: Any?): Response<EndPointResult<String>>

    @POST("api/services/app/Account/ChangeEmailAddress")
    suspend fun changeEmailAddress(@Body req: Any?): Response<EndPointResult<String>>

    @POST("api/services/app/Account/ConfirmEmailAddressChanges")
    suspend fun confirmEmailAddressChanges(@Body req: Any?): Response<EndPointResult<String>>

    @PUT("api/services/app/Shipper/UpdateMyProfile")
    suspend fun updateProfileInfo(@Body req: Any?): Response<EndPointResult<String>>

    @GET("api/services/app/Shipper/GetMyProfile")
    suspend fun getProfileInfo(): Response<EndPointResult<Profile>>

    //Verify Session
    @POST("api/services/app/Session/Verify")
    suspend fun verifySession(): Response<EndPointResult<VerifySession>>


    //Change password
    @POST("api/services/app/User/ChangePassword")
    suspend fun changePassword(@Body changePasswordBody: ChangePasswordBody): Response<EndPointResult<Boolean>>

    //Forgot password
    @POST("api/services/app/Account/ForgetPassword")
    suspend fun forgotPassword(@Body body: Any): Response<EndPointResult<ForgotPasswordResponse>>

    //Reset password
    @POST("api/services/app/Account/ResetPassword")
    suspend fun resetPassword(@Body resetPasswordBody: ResetPasswordBody): Response<EndPointResult<Boolean>>


    //Validate reset password code
    @POST("api/services/app/Account/ValidateResetPasswordCode")
    suspend fun validateResetPasswordCode(@Body validateResetPasswordCodeRequest: ValidateResetPasswordCodeBody): Response<EndPointResult<Boolean>>


    //Update Avatar
    @Multipart
    @PUT("api/services/app/User/UpdateAvatar")
    suspend fun updateAvatar(@Part avatar: MultipartBody.Part): Response<EndPointResult<String>>

}