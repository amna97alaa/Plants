package com.amna.repository.dto.disease

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("current_page")
    val currentPage: Int?,
    @SerializedName("data")
    val `data`: T?,
    @SerializedName("from")
    val from: Int?,
    @SerializedName("last_page")
    val lastPage: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("to")
    val to: Int?,
    @SerializedName("total")
    val total: Int?
)