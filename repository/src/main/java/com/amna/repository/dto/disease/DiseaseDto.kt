package com.amna.repository.dto.disease


import com.google.gson.annotations.SerializedName

data class DiseaseDto<T>(
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("description")
    val description: List<Description?>?,
    @SerializedName("family")
    val family: Any?,
    @SerializedName("host")
    val host: List<String?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("images")
    val images: List<Image?>?,
    @SerializedName("other_name")
    val otherName: List<String?>?,
    @SerializedName("scientific_name")
    val scientificName: String?,
    @SerializedName("solution")
    val solution: List<Solution?>?
)