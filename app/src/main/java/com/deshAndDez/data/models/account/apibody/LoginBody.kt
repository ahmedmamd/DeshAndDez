package com.deshAndDez.data.models.account.apibody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginBody {
    @SerializedName("UsernameOrEmailAddress")
    @Expose
    var usernameOrEmailAddress: String? = null

    @SerializedName("Password")
    @Expose
    var password: String? = null

    @SerializedName("rememberClient")
    @Expose
    var rememberClient: Boolean? = null

}