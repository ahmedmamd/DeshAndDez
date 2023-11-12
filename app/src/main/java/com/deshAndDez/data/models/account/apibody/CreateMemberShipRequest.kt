package com.deshAndDez.data.models.account.apibody

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateMemberShipRequest {
    @SerializedName("emailAddress")
    @Expose
    var emailAddress: String? = null

    @SerializedName("phoneNumber")
    @Expose
    var phoneNumber: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("surname")
    @Expose
    var surname: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("cityId")
    @Expose
    var cityId: String? = null

    @SerializedName("governorateId")
    @Expose
    var governorateId: String? = null

    @SerializedName("verificationWay")
    @Expose
    var verificationWay : Int? = null
}
