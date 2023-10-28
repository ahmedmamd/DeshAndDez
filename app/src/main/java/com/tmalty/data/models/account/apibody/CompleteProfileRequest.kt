package com.tmalty.data.models.account.apibody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CompleteProfileRequest {
    @SerializedName("birthdate")
    @Expose
    var birthdate: String? = null
    @SerializedName("cityId")
    @Expose
    var cityId: String? = null
    @SerializedName("gender")
    @Expose
    var gender: Int? = null
}