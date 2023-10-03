package com.amna.repository.dto.disease


import com.google.gson.annotations.SerializedName

data class Solution(
    @SerializedName("description")
    val description: String?,
    @SerializedName("subtitle")
    val subtitle: String?
)