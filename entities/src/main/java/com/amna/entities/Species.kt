package com.amna.entities

data class Species(
    val commonName: String,
    val cycle: String,
    val defaultImage: List<DefaultImage>,
    val id: Int,
    val otherName: List<String?>,
    val scientificName: List<String?>,
    val sunlight: List<String?>,
    val watering: String
) {
    data class DefaultImage(
        val mediumUrl: String,
        val originalUrl: String,
        val regularUrl: String,
        val smallUrl: String,
        val thumbnail: String
    )
}