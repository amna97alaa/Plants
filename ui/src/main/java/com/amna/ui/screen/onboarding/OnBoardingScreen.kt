package com.amna.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(
    modifier: Modifier = Modifier,
    item: List<String> = emptyList(),
    pagerState: PagerState
) {
    val pageCount = 3
    val pagerState = pagerState

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,

        ) { page ->

    }

}