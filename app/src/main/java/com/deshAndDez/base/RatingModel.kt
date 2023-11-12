package com.deshAndDez.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//this model is an entity for spinners of selection menus
data class RatingModel(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("rating")
    @Expose
    var rating: Int? = null,
)