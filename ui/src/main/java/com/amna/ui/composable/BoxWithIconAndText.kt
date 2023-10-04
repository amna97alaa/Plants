package com.amna.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amna.ui.R
import com.amna.ui.theme.BoxColor
import com.amna.ui.theme.TextPrimary60
import com.amna.ui.theme.TextSecondary60

@Composable
fun BoxWithIconAndText(
    icon: Painter,
    text: String,
    onClickBox: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(BoxColor)
            .size(height = 120.dp, width = 118.dp)
            .clickable { onClickBox }

    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        ) {
            Icon(
                modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.CenterHorizontally),
                painter = icon,
                contentDescription = null,
                tint = TextPrimary60
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                fontSize = 12.sp,
                color = TextPrimary60,
                maxLines = 1
            )
        }
    }
}

@Preview()
@Composable
fun previewBox() {
    BoxWithIconAndText(
        icon = painterResource(id = R.drawable.ic_waterdrops),
        text = "Watering",
        onClickBox = {}
    )
}