package com.amna.usecase.repository

import com.amna.entities.BaseEntity
import com.amna.entities.Disease
import com.amna.entities.Guide
import com.amna.entities.Question
import com.amna.entities.Species

interface PlantsRepository {
    suspend fun getAllPlants(): BaseEntity<List<Species.DefaultImage>>
    suspend fun getIndoorPlants(indoor: Int): List<Species.DefaultImage>
    suspend fun getOutdoorPlants(indoor: Int): List<Species.DefaultImage>
    suspend fun getEdiblePlants(edible: Int): List<Species.DefaultImage>
    suspend fun getPoisonousPlants(poisonous: Int): List<Species.DefaultImage>
    suspend fun searchPlants(query: String): List<Species.DefaultImage>
    suspend fun getAllDisease(): List<Disease.Description>
    suspend fun getImagesDisease(): List<Disease.Image>
    suspend fun getDiseaseSolution(): List<Disease.Solution>
    suspend fun getPlantGuides(): List<Guide>
    suspend fun getSectionsGuides(): List<Guide.Section>
    suspend fun getFrequentQuestions(speciesId: Int): List<Question>
    suspend fun getImagesQuestion(): List<Question.QuestionImage>
}