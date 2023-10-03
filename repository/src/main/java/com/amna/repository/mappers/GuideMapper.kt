package com.amna.repository.mappers

import com.amna.entities.Guide
import com.amna.repository.dto.plantGuide.GuideData
import com.amna.repository.dto.plantGuide.Section

fun GuideData<Section>.toGuide(): Guide {
    return Guide(
        commonName = commonName ?: "",
        id = id ?: 0,
        speciesId = speciesId ?: 0,
        scientificName = scientificName ?: emptyList(),
        section = section?.map {
            Guide.Section(
                it?.description ?: "",
                it?.id ?: 0,
                it?.type ?: " ",
            )
        } ?: emptyList()
    )
}