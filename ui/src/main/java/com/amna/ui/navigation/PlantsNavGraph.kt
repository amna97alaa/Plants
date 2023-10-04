package com.amna.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.amna.ui.LocalNavController

@Composable
fun PlantsNavGraph() {
    NavHost(LocalNavController.current, startDestination = PlantsDestination.Splash.route) {

    }
}