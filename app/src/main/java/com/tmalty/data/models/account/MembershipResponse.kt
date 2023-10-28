package com.tmalty.data.models.account

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MembershipResponse {
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("membershipIdentity")
    @Expose
    var membershipIdentity: String? = null
}