package com.deshAndDez.data.models.all_reels.comments.replay

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Replay(
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