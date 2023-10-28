package com.tmalty.data.models.notification

import com.google.gson.annotations.SerializedName

class Notification(
    @SerializedName("creationTime"      ) var creationTime      : String? = null,
    @SerializedName("id"                ) var id                : String? = null,
    @SerializedName("entityId"          ) var entityId          : String? = null,
    @SerializedName("subEntityId"       ) var subEntityId       : String? = null,
    @SerializedName("content"           ) var content           : String? = null,
    @SerializedName("title"             ) var title             : String? = null,
    @SerializedName("notificationName"  ) var notificationName  : String? = null,
    @SerializedName("notificationType"  ) var notificationType  : Int?    = null,
    @SerializedName("notificationImage" ) var notificationImage : String? = null,
    @SerializedName("notificationState" ) var notificationState : Int?    = null
)