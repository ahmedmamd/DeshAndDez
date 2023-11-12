package com.deshAndDez.data.models.account

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VerifySessionModel {
    @SerializedName("sessionStatus")
    @Expose
    var sessionStatus: Int? = null
    @SerializedName("btnActionType")
    @Expose
    var btnActionType: Int? = null

    @SerializedName("actionBtnLabel")
    @Expose
    var actionBtnLabel: String? = null

    @SerializedName("actionBtnNavigationLink")
    @Expose
    var actionBtnNavigationLink: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("isInNormalMode")
    @Expose
    var isInNormalMode: Boolean? = false

    @SerializedName("isAuthenticated")
    @Expose
    var isAuthenticated: Boolean? = false

    @SerializedName("unSeenNotificationsCount")
    var unSeenNotificationsCount: Int? = null

    @SerializedName("appContactsDto")
    var appContactsDto: AppContactsDto? = null
    class AppContactsDto {

        @SerializedName("facebook")
        var facebook: String? = null
        @SerializedName("youTube")
        var youTube: String? = null
        @SerializedName("emailAddress")
        var emailAddress: String? = null
        @SerializedName("phoneNumber")
        var phoneNumber: String? = null
        @SerializedName("instagram")
        var instagram: String? = null

    }
}