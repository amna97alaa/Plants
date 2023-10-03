package com.amna.entities

data class Guide(
    val commonName: String,
    val id: Int,
    val scientificName: List<String?>,
    val section: List<Section?>,
    val speciesId: Int
) {
    data class Section(
        val description: String,
        val id: Int,
        val type: String
    )
}