package com.tmalty.data.models.account.apibody

import com.google.gson.annotations.SerializedName

class ForgotPasswordResponse {
    @SerializedName("message"         ) var message         : String? = null
    @SerializedName("accountIdentity" ) var accountIdentity : String? = null
}