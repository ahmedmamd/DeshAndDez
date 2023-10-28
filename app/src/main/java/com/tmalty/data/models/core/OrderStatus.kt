package com.tmalty.data.models.core

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderStatus(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,

)