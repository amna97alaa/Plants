package com.amna.entities

data class Disease(
    val commonName: String,
    val description: List<Description>,
    val family: Any,
    val host: Any,
    val id: Int,
    val images: List<Image>,
    val otherName: List<String?>?,
    val scientificName: String,
    val solution: List<Solution?>
) {
    data class Description(
        val description: String,
        val subtitle: String
    )

    data class Image(
        val licenseUrl: String,
        val mediumUrl: String,
        val originalUrl: String,
        val regularUrl: String,
        val smallUrl: String,
        val thumbnail: String
    )

    data class Solution(
        val description: String,
        val subtitle: String
    )
}