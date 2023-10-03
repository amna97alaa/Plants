package com.amna.repository.dto.faq


import com.google.gson.annotations.SerializedName

data class QuestionImage(
    @SerializedName("license")
    val license: Int?,
    @SerializedName("license_name")
    val licenseName: String?,
    @SerializedName("license_url")
    val licenseUrl: String?,
    @SerializedName("medium_url")
    val mediumUrl: String?,
    @SerializedName("original_url")
    val originalUrl: String?,
    @SerializedName("regular_url")
    val regularUrl: String?
)