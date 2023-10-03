package com.amna.repository.dto.plantGuide


import com.google.gson.annotations.SerializedName

data class GuideData<T>(
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("scientific_name")
    val scientificName: List<String?>?,
    @SerializedName("section")
    val section: List<Section?>?,
    @SerializedName("species_id")
    val speciesId: Int?
)