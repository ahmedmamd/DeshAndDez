package com.deshAndDez.data.models.all_reels.country

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Country(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("text")
    @Expose
    var text: String? = null,
    @SerializedName("image")
    @Expose
    var image: Int? = null,
    @SerializedName("isSelected")
    @Expose
    var isSelected: Boolean? = null,
)