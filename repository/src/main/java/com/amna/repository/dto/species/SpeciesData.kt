package com.amna.repository.dto.species


import com.google.gson.annotations.SerializedName

data class SpeciesData<T>(
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("cycle")
    val cycle: String?,
    @SerializedName("default_image")
    val defaultImage: List<DefaultImage?>,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("other_name")
    val otherName: List<String?>?,
    @SerializedName("scientific_name")
    val scientificName: List<String?>?,
    @SerializedName("sunlight")
    val sunlight: List<String?>?,
    @SerializedName("watering")
    val watering: String?
)