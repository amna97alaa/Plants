//package com.amna.repository.mappers
//
//import com.amna.entities.BaseEntity
//import com.amna.entities.Species
//import com.amna.repository.dto.disease.BaseResponse
//import com.amna.repository.dto.species.DefaultImage
//import com.amna.repository.dto.species.SpeciesData
//
//fun BaseResponse<List<SpeciesData<DefaultImage>>>.toSpecies(): Species {
//    return BaseEntity(
//        currentPage = currentPage ?: 0,
//        data = data ,
//
//
//    )
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
////Species(
////commonName = commonName ?: "",
////cycle = cycle ?: "",
////defaultImage = defaultImage.map {
////    Species.DefaultImage(
////        it?.mediumUrl ?: "",
////        it?.originalUrl ?: "",
////        it?.regularUrl ?: "",
////        it?.smallUrl ?: "",
////        it?.thumbnail ?: ""
////    )
////},
////id = id ?: 0,
////otherName = otherName ?: emptyList(),
////scientificName = scientificName ?: emptyList(),
////sunlight = sunlight ?: emptyList(),
////watering = watering ?: ""
////)