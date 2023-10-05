package com.amna.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.amna.ui.theme.ChipColor
import com.amna.ui.theme.Dimens
import com.amna.ui.theme.Primary

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    numberOfPages: Int,
    selectedPage: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimens().dimens16),
        modifier = modifier,
    ) {
        (0 until numberOfPages).forEach { pageNumber ->

            val isSelected = pageNumber == selectedPage

            PageIndicatorItem(isSelected = isSelected)
        }
    }
}

@Composable
private fun PageIndicatorItem(
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val color: Color by animateColorAsState(

        targetValue = if (isSelected) {
            Primary
        } else {
            ChipColor
        },
        animationSpec = tween(
            durationMillis = 300,
        ), label = ""
    )
    val width: Dp by animateDpAsState(

        targetValue = if (isSelected) {
            Dimens().dimens16
        } else {
            Dimens().dimens16
        },
        animationSpec = tween(
            durationMillis = 300,
        ), label = ""
    )
    Canvas(
        modifier = modifier.size(width = width, height = Dimens().dimens16),
    ) {
        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = Size(
                width = width.toPx(),
                height = Dimens().dimens16.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = Dimens().dimens16.toPx(),
                y = Dimens().dimens16.toPx(),
            ),
        )
    }
}