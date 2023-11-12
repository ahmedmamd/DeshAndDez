package com.deshAndDez.data.models.account.apibody

import com.google.gson.annotations.SerializedName

class ChangePasswordBody(
    @SerializedName("currentPassword") var currentPassword: String? = null,
    @SerializedName("newPassword") var newPassword: String? = null
)