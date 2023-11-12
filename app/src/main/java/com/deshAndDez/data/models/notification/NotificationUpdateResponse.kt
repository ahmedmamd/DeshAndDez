package com.deshAndDez.data.models.notification

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotificationUpdateResponse(
    @SerializedName("message")
    @Expose
    var message: String? = null,
    @SerializedName("unReadCount")
    @Expose
    var unReadCount: Int? = null


)