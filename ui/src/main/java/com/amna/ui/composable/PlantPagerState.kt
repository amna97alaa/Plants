package com.amna.ui.composable

import androidx.annotation.DrawableRes
import com.amna.ui.R


sealed class PlantPagerState(
    @DrawableRes val imageResource: Int,
    val title: String
) {

    data object First : PlantPagerState(
        R.drawable.plant1,
        "Where every leaf tells a story"
    )

    data object Second : PlantPagerState(
        R.drawable.plant2,
        "planting dreams, one pot at a time"
    )

    data object Third : PlantPagerState(
        R.drawable.plant3,
        "Unlock the secrets of a greener world"
    )
}