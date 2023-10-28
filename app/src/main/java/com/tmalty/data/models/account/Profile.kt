package com.tmalty.data.models.account

import com.google.gson.annotations.SerializedName

class Profile {
    @SerializedName("gender")
    var gender: Int? = null
    @SerializedName("identityVerificationStatus")
    var identityVerificationStatus: String? = null
    @SerializedName("identityVerificationStatusEnum")
    var identityVerificationStatusEnum: Int? = null
    @SerializedName("unSeenNotificationsCount")
    var unSeenNotificationsCount: Int? = null
    @SerializedName("unSeenMessagesCount")
    var unSeenMessagesCount: Int? = null
    @SerializedName("currentCartProductsCount")
    var currentCartProductsCount: Int? = null
    @SerializedName("linkedWithBiometric")
    var linkedWithBiometric: Boolean? = null
    @SerializedName("isProfileCompleted")
    var isProfileCompleted: Boolean? = null
    @SerializedName("userId")
    var userId: Int? = null
    @SerializedName("avatarPath")
    var avatarPath: String? = null
    @SerializedName("shipperName")
    var shipperName: String? = null
    @SerializedName("fullName")
    var fullName: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("surname")
    var surname: String? = null
    @SerializedName("countryId")
    var countryId: Int? = null
    @SerializedName("countryName")
    var countryName: String? = null
    @SerializedName("cityId")
    var cityId: String? = null
    @SerializedName("governorateId")
    var governorateId: String? = null
    @SerializedName("cityName")
    var cityName: String? = null
    @SerializedName("governorateName")
    var governorateName: String? = null
    @SerializedName("emailAddress")
    var emailAddress: String? = null
    @SerializedName("logoPath")
    var logoPath: String? = null
    @SerializedName("birthDate")
    var birthDate: String? = null
    @SerializedName("address")
    var address: String? = null
    @SerializedName("phoneNumber")
    var phoneNumber: String? = null
    @SerializedName("id")
    var id: String? = null
}