package com.amna.repository.repository

import com.amna.entities.BaseEntity
import com.amna.entities.Disease
import com.amna.entities.Guide
import com.amna.entities.Question
import com.amna.entities.Species
import com.amna.repository.source.RemoteDataSource
import com.amna.usecase.repository.PlantsRepository
import javax.inject.Inject

class PlantsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : PlantsRepository, BaseRepository() {
    override suspend fun getAllPlants(): BaseEntity<List<Species.DefaultImage>> {
        return remoteDataSource.getAllPlants(page = 1)
    }

    override suspend fun getIndoorPlants(indoor: Int): List<Species.DefaultImage> {
        TODO("Not yet implemented")
    }

    override suspend fun getOutdoorPlants(indoor: Int): List<Species.DefaultImage> {
        TODO("Not yet implemented")
    }

    override suspend fun getEdiblePlants(edible: Int): List<Species.DefaultImage> {
        TODO("Not yet implemented")
    }

    override suspend fun getPoisonousPlants(poisonous: Int): List<Species.DefaultImage> {
        TODO("Not yet implemented")
    }

    override suspend fun searchPlants(query: String): List<Species.DefaultImage> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDisease(): List<Disease.Description> {
        TODO("Not yet implemented")
    }

    override suspend fun getImagesDisease(): List<Disease.Image> {
        TODO("Not yet implemented")
    }

    override suspend fun getDiseaseSolution(): List<Disease.Solution> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlantGuides(): List<Guide> {
        TODO("Not yet implemented")
    }

    override suspend fun getSectionsGuides(): List<Guide.Section> {
        TODO("Not yet implemented")
    }

    override suspend fun getFrequentQuestions(speciesId: Int): List<Question> {
        TODO("Not yet implemented")
    }

    override suspend fun getImagesQuestion(): List<Question.QuestionImage> {
        TODO("Not yet implemented")
    }

}