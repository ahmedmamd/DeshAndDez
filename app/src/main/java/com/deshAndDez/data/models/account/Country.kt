package com.deshAndDez.data.models.account

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Country(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null
)