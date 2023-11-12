package com.deshAndDez.data.models.account.apibody

import com.google.gson.annotations.SerializedName

class ValidateResetPasswordCodeBody(
    @SerializedName("accountIdentity") var accountIdentity: String? = null,
    @SerializedName("passwordResetCode") var passwordResetCode: String? = null
)