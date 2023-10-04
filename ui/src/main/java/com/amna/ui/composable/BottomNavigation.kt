package com.amna.ui.composable

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.amna.ui.LocalNavController
import com.amna.ui.navigation.PlantsDestination
import com.amna.ui.theme.Background
import com.amna.ui.theme.Dimens
import com.amna.ui.theme.Primary
import kotlin.system.exitProcess

@Composable
fun currentDestination(): NavDestination? {
    val navBackStackEntry by LocalNavController.current.currentBackStackEntryAsState()
    return navBackStackEntry?.destination
}

@Composable
fun BottomNavBar(visibility: Boolean) {
    val items by remember {
        mutableStateOf(
            listOf(
                PlantsDestination.Home,
                PlantsDestination.Search,
                PlantsDestination.Diseases,
                PlantsDestination.FAQ,
            )
        )
    }

    AnimatedVisibility(visibility) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens().dimens70)
                .background(Background),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                BottomNavItem(
                    screen = screen,
                    currentDestination = currentDestination(),
                )
            }
        }
    }
}


@Composable
fun BottomNavItem(
    screen: PlantsDestination,
    currentDestination: NavDestination?,
) {
    val navController = LocalNavController.current
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    BackHandler {
        if (currentDestination?.route == PlantsDestination.Home.route) {
            exitProcess(0)
        } else {
            navController.navigate(PlantsDestination.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
    Row(modifier=Modifier.background(Primary)
        .wrapContentSize()
        .clip(RoundedCornerShape(16.dp))) {
        Icon(
            modifier = Modifier
                .clickable {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            painter = painterResource(if (selected) screen.isSelected!! else screen.isUnSelected!!),
            contentDescription = ""
        )
    }
}