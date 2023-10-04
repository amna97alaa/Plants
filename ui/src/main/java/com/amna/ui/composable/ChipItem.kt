package com.amna.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amna.ui.theme.color
import com.amna.ui.theme.radius

@Composable
fun ChipItem(
    text: String,
    modifier: Modifier,
    onClickChip: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .clickable { onClickChip }) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.color.chipColor)
                .padding(vertical = 4.dp, horizontal = 8.dp),
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.color.textPrimary60,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}