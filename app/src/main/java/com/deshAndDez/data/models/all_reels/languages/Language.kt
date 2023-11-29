package com.deshAndDez.data.models.all_reels.languages

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Language(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("text")
    @Expose
    var text: String? = null,
    @SerializedName("isSelected")
    @Expose
    var isSelected: Boolean? = null,
)