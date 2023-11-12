package com.deshAndDez.data.models.account.apibody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UpdateProfileBody {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("surname")
    @Expose
    var surname: String? = null
    @SerializedName("phoneNumber")
    @Expose
    var phone: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
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