package com.amna.ui.screen.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amna.ui.navigation.PlantsDestination

fun NavGraphBuilder.splashRoute() {
    composable(route = PlantsDestination.Splash.route) {
        SplashScreen()
    }
}