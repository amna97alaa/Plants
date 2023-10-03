package com.amna.repository.mappers

import com.amna.entities.Disease
import com.amna.repository.dto.disease.Description
import com.amna.repository.dto.disease.DiseaseDto

fun DiseaseDto<Description>.toDisease(): Disease {
    return Disease(
        commonName = commonName ?: " ",
        description = description?.map {
            Disease.Description(
                description = it?.description ?: "",
                subtitle = it?.subtitle ?: ""
            )
        } ?: emptyList(),
        family = family ?: "",
        host = host ?: "",
        id = id ?: 0,
        otherName = otherName,
        scientificName = scientificName ?: "",
        solution = solution?.map {
            Disease.Solution(
                it?.description ?: "",
                it?.subtitle ?: ""
            )
        } ?: emptyList(),
        images = images?.map {
            Disease.Image(
                it?.licenseUrl ?: "",
                it?.mediumUrl ?: "",
                it?.originalUrl ?: "",
                it?.regularUrl ?: "",
                it?.smallUrl ?: "",
                it?.thumbnail ?: ""
            )
        } ?: emptyList()

    )
}