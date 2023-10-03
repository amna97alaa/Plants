package com.amna.repository.dto.plantGuide


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("type")
    val type: String?
)