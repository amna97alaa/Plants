package com.amna.repository.source

import com.amna.repository.dto.disease.BaseResponse
import com.amna.repository.dto.disease.Description
import com.amna.repository.dto.disease.DiseaseDto
import com.amna.repository.dto.disease.Solution
import com.amna.repository.dto.faq.QuestionData
import com.amna.repository.dto.faq.QuestionImage
import com.amna.repository.dto.plantGuide.GuideData
import com.amna.repository.dto.plantGuide.Section
import com.amna.repository.dto.species.DefaultImage
import com.amna.repository.dto.species.SpeciesData

interface RemoteDataSource {
    suspend fun getAllPlants(page: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun getIndoorPlants(page: Int, indoor: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun getOutdoorPlants(page: Int, indoor: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun getEdiblePlants(page: Int, edible: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun getPoisonousPlants(page: Int, poisonous: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun searchPlants(page: Int, query: String): BaseResponse<List<SpeciesData<List<DefaultImage>>>>

    suspend fun getAllDisease(page: Int): BaseResponse<List<DiseaseDto<List<Description>>>>

    suspend fun getDiseaseSolution(page: Int): BaseResponse<List<DiseaseDto<List<Solution>>>>

    suspend fun getSearchDiseaseResult(
        page: Int,
        query: String
    ): BaseResponse<List<DiseaseDto<Description>>>

    suspend fun getSearchDiseaseSolutionResult(
        page: Int,
        query: String
    ): BaseResponse<List<DiseaseDto<Solution>>>

    suspend fun getPlantGuides(page: Int, speciesId: Int): BaseResponse<List<GuideData<List<Section>>>>

    suspend fun getFrequentQuestions(page: Int): BaseResponse<List<QuestionData<List<QuestionImage>>>>
}