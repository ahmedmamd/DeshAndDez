package com.deshAndDez.fcm

import com.google.gson.annotations.SerializedName

class FcmModel (
    @SerializedName("entityId" ) var entityId : String? = null,
    @SerializedName("body"     ) var body     : String? = null,
    @SerializedName("type"     ) var type     : String? = null,
    @SerializedName("unSeenNotificationsCount") var unSeenNotificationsCount  : Int? = null,
)