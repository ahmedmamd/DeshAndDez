package com.deshAndDez.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//this model is an entity for spinners of selection menus
data class SelectionModel(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("isSelected")
    @Expose
    var isSelected: String? = null,
)