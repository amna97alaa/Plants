package com.amna.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.amna.ui.LocalNavController
import com.amna.ui.composable.PlantPagerState
import com.amna.ui.composable.PageIndicator
import com.amna.ui.composable.Pager
import com.amna.ui.navigation.PlantsDestination
import com.amna.ui.screen.home.navigateToHome
import com.amna.ui.theme.ChipColor
import com.amna.ui.theme.Dimens
import com.amna.ui.theme.Primary
import com.amna.ui.theme.TextPrimary87
import com.amna.viewmodel.onboarding.OnBoardingInteraction
import com.amna.viewmodel.onboarding.OnBoardingViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    onboardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val navController = LocalNavController.current
    val state by onboardingViewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(TextPrimary87, darkIcons = false)

    LaunchedEffect(key1 = Unit) {
        if (state.loggedIn) {
            navController.navigateToHome {
                popUpTo(PlantsDestination.OnBoarding.route) {
                    inclusive = true
                }
            }
        }
    }

    OnboardingContent(onClickGetStarted = {navController.navigateToHome()})
}

val onboardingPages =
    listOf(PlantPagerState.First, PlantPagerState.Second, PlantPagerState.Third)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingContent(
    onClickGetStarted: () -> Unit,
    onBoardingInteraction: OnBoardingInteraction,
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HorizontalPager(
            modifier = Modifier,
            pageCount = onboardingPages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            Pager(
                onBoardingPage = onboardingPages[position],
                ""
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens().dimens16, vertical = Dimens().dimens16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                numberOfPages = onboardingPages.size,
                selectedPage = pagerState.currentPage
            )
            Button(
                onClick = {
                    if (pagerState.currentPage != 2) {
                        coroutineScope.launch {
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                        }
                    } else {

                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text(
                    text = if (pagerState.currentPage != 2) "" else "",
                    color = ChipColor
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnBoardingScreen()
}



//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun Pager(
//    modifier: Modifier = Modifier,
//    item: List<String> = emptyList(),
//    pagerState: PagerState
//) {
//    val pageCount = 3
//    val pagerState = pagerState
//
//    HorizontalPager(
//        state = pagerState,
//        modifier = modifier,
//        verticalAlignment = Alignment.CenterVertically,
//
//        ) { page ->
//
//    }
//
//}