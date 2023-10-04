package com.amna.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.amna.ui.composable.BottomNavBar
import com.amna.ui.composable.currentDestination
import com.amna.ui.navigation.PlantsDestination
import com.amna.ui.navigation.PlantsNavGraph

val LocalNavController =
    compositionLocalOf<NavHostController> { error("No NavController found!") }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlantsApp() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            bottomBar = {
                val visibility =
                    (currentDestination()?.route ?: "") in listOf(
                        PlantsDestination.Home.route,
                        PlantsDestination.Search.route,
                        PlantsDestination.Diseases.route,
                        PlantsDestination.FAQ.route,
                    )
                BottomNavBar(visibility)
            }
        ) {
            PlantsNavGraph()
        }
    }
}