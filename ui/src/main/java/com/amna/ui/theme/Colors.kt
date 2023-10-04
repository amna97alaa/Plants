package com.amna.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val background: Color = Background,
    val primary: Color = Primary,
    val chipColor: Color = ChipColor,
    val cardColor: Color = CardColor,
    val boxColor: Color = BoxColor,
    val textPrimary87: Color = TextPrimary87,
    val textPrimary60: Color = TextPrimary60,
    val textPrimary37: Color = TextPrimary37,
    val textSecondary60: Color = TextSecondary60

)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.color: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current