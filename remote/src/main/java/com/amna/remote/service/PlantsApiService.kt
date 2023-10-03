package com.amna.remote.service

import com.amna.repository.dto.faq.QuestionData
import com.amna.repository.dto.faq.QuestionImage
import com.amna.repository.dto.plantGuide.GuideData
import com.amna.repository.dto.plantGuide.Section
import com.amna.repository.dto.species.DefaultImage
import com.amna.repository.dto.species.SpeciesData
import com.amna.repository.dto.disease.BaseResponse
import com.amna.repository.dto.disease.Description
import com.amna.repository.dto.disease.DiseaseDto
import com.amna.repository.dto.disease.Solution
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantsApiService {

    @GET("species-list")
    suspend fun getAllPlants(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>


    @GET("species-list")
    suspend fun getIndoorPlants(
        @Query("page") page: Int? = 1,
        @Query("indoor") indoor: Int = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>

    @GET("species-list")
    suspend fun getOutdoorPlants(
        @Query("page") page: Int? = 1,
        @Query("indoor") indoor: Int = 0,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>

    @GET("species-list")
    suspend fun getEdiblePlants(
        @Query("page") page: Int? = 1,
        @Query("edible") edible: Int = 0,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>

    @GET("species-list")
    suspend fun getPoisonousPlants(
        @Query("page") page: Int? = 1,
        @Query("poisonous") poisonous: Int = 0,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>


    //
    @GET("species-list")
    suspend fun searchPlants(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147",
        @Query("q") query: String
    ): Response<BaseResponse<List<SpeciesData<List<DefaultImage>>>>>


    @GET("pest-disease-list")
    suspend fun getAllDisease(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<DiseaseDto<List<Description>>>>>

    @GET("pest-disease-list")
    suspend fun getDiseaseSolution(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<DiseaseDto<List<Solution>>>>>


    @GET("pest-disease-list")
    suspend fun getSearchDiseaseResult(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147",
        @Query("q") query: String
    ): Response<BaseResponse<List<DiseaseDto<Description>>>>

    @GET("pest-disease-list")
    suspend fun getSearchDiseaseSolutionResult(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147",
        @Query("q") query: String
    ): Response<BaseResponse<List<DiseaseDto<Solution>>>>


    //
    @GET("species-care-guide-list")
    suspend fun getPlantGuides(
        @Query("page") page: Int? = 1,
        @Query("species_id") speciesId: Int,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
//        true
    ): Response<BaseResponse<List<GuideData<List<Section>>>>>


    @GET("article-faq-list")
    suspend fun getFrequentQuestions(
        @Query("page") page: Int? = 1,
        @Query("key") key: String = "sk-sqWz6500d388cc3bb2147"
    ): Response<BaseResponse<List<QuestionData<List<QuestionImage>>>>>
}

