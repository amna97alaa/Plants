package com.amna.remote.source

import com.amna.entities.error.BadRequestException
import com.amna.entities.error.DeleteException
import com.amna.entities.error.NoInternetException
import com.amna.entities.error.NotFoundException
import com.amna.entities.error.NullResultException
import com.amna.entities.error.ServerException
import com.amna.entities.error.ValidationException
import com.amna.remote.service.PlantsApiService
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
import com.amna.repository.source.RemoteDataSource
import okio.IOException
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val plantsApiService: PlantsApiService
) : RemoteDataSource {
    override suspend fun getAllPlants(page: Int): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse { plantsApiService.getAllPlants(page = page) }
    }

    override suspend fun getIndoorPlants(
        page: Int,
        indoor: Int
    ): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse { plantsApiService.getIndoorPlants(page = page, indoor = indoor) }
    }

    override suspend fun getOutdoorPlants(
        page: Int,
        indoor: Int
    ): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse { plantsApiService.getOutdoorPlants(page = page, indoor = indoor) }
    }

    override suspend fun getEdiblePlants(
        page: Int,
        edible: Int
    ): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse { plantsApiService.getEdiblePlants(page = page, edible = edible) }
    }

    override suspend fun getPoisonousPlants(
        page: Int,
        poisonous: Int
    ): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse {
            plantsApiService.getPoisonousPlants(
                page = page,
                poisonous = poisonous
            )
        }
    }

    override suspend fun searchPlants(
        page: Int,
        query: String
    ): BaseResponse<List<SpeciesData<List<DefaultImage>>>> {
        return wrapApiResponse { plantsApiService.searchPlants(page = page, query = query) }
    }

    override suspend fun getAllDisease(page: Int): BaseResponse<List<DiseaseDto<List<Description>>>> {
        return wrapApiResponse { plantsApiService.getAllDisease(page = page) }
    }

    override suspend fun getDiseaseSolution(page: Int): BaseResponse<List<DiseaseDto<List<Solution>>>> {
        return wrapApiResponse { plantsApiService.getDiseaseSolution(page = page) }
    }

    override suspend fun getSearchDiseaseResult(
        page: Int,
        query: String
    ): BaseResponse<List<DiseaseDto<Description>>> {
        return wrapApiResponse {
            plantsApiService.getSearchDiseaseResult(
                page = page,
                query = query
            )
        }
    }

    override suspend fun getSearchDiseaseSolutionResult(
        page: Int,
        query: String
    ): BaseResponse<List<DiseaseDto<Solution>>> {
        return wrapApiResponse {
            plantsApiService.getSearchDiseaseSolutionResult(
                page = page,
                query = query
            )
        }
    }

    override suspend fun getPlantGuides(
        page: Int,
        speciesId: Int
    ): BaseResponse<List<GuideData<List<Section>>>> {
        return wrapApiResponse {
            plantsApiService.getPlantGuides(
                page = page,
                speciesId = speciesId
            )
        }
    }

    override suspend fun getFrequentQuestions(page: Int): BaseResponse<List<QuestionData<List<QuestionImage>>>> {
        return wrapApiResponse { plantsApiService.getFrequentQuestions(page = page) }
    }


    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body() ?: throw NullResultException("No data")
            } else {
                throw when (response.code()) {
                    400 -> BadRequestException(response.message())
                    401 -> ValidationException("Invalid username or password")
                    404 -> NotFoundException("Not found")
                    500 -> DeleteException("Deleted Successfully")
                    else -> ServerException("Server error")
                }
            }
        } catch (e: UnknownHostException) {
            throw NoInternetException("no Internet")
        } catch (io: IOException) {
            throw NoInternetException(io.message)
        }
    }
}