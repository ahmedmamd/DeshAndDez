package com.deshAndDez.ui.adapters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("username")
    @Expose
    var username: String? = null,
    @SerializedName("image")
    @Expose
    var image: Int? = null,
    @SerializedName("isFollowed")
    @Expose
    var isFollowed: Boolean? = null,
)