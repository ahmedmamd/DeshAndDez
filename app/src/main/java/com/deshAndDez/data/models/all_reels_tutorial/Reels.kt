package com.deshAndDez.data.models.all_reels_tutorial

import com.google.gson.annotations.SerializedName

data class MainVideo(
    @SerializedName("id") val id: Int,
    @SerializedName("tutorial_id") val tutorialId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("caption") val caption: String,
    @SerializedName("url") val url: String,
    @SerializedName("screenshot_url") val screenshotUrl: String?,
    @SerializedName("main") val isMain: Boolean,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("views_count") val viewsCount: Int=0,
    @SerializedName("favourites_count") val favouritesCount: Int,
    @SerializedName("is_favourited") val isFavourited: Boolean
)

data class TutorialVideos(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("screenshot_url") var screenshot_url: String? = null,
    @SerializedName("tutorial_id") var tutorialId: Int? = null,
    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("caption") var caption: String? = null,
    @SerializedName("processed") var processed: Int? = null,
    @SerializedName("enc_video_id") var encVideoId: String? = null,
    @SerializedName("enc_video_filename") var encVideoFilename: String? = null,
    @SerializedName("processed_percentage") var processedPercentage: String? = null,
    @SerializedName("length_in_seconds") var lengthInSeconds: Int? = null,
    @SerializedName("views_count") var views: Int? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("favourites_count") var favouritesCount: Int? = null,
    @SerializedName("is_favourited") var isFavourites: Boolean? = null,
    @SerializedName("comments_count") var commentsCount: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("shares_count") var sharesCount: Int? =null,
    @SerializedName("type") var type: String? =null,
)