package com.amna.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.amna.ui.navigation.PlantsDestination

fun NavGraphBuilder.homeRoute() {
    composable(route = PlantsDestination.Home.route) {
        HomeScreen()
    }
}

fun NavController.navigateToHome(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(PlantsDestination.Home.route, builder = builder)
}