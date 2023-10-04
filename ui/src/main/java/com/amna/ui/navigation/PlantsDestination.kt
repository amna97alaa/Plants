package com.amna.ui.navigation

import com.amna.ui.R

sealed class PlantsDestination(
    val route: String,
    val isSelected: Int? = null,
    val isUnSelected: Int? = null
) {
    data object Splash : PlantsDestination("splash")
    data object OnBoarding : PlantsDestination("onBoarding")
    data object PlantDetails : PlantsDestination("plantDetails")
    data object WateringDetails : PlantsDestination("wateringDetails")
    data object PruningDetails : PlantsDestination("pruningDetails")
    data object SunlightDetails : PlantsDestination("sunlightDetails")
    data object SolutionDetails : PlantsDestination("solutionDetails")
    data object SeeAllPlants : PlantsDestination("seeAllPlants")


    data object Home :PlantsDestination(
        "home",
        R.drawable.ic_home
    )

    data object Search :PlantsDestination(
        "search",
        R.drawable.ic_search
    )

    data object Diseases :PlantsDestination(
        "diseases",
        R.drawable.ic_documents
    )

    data object FAQ :PlantsDestination(
        "faq",
        R.drawable.ic_question
    )
}
