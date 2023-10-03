package com.amna.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amna.ui.theme.color
import com.amna.ui.theme.dimens
import com.amna.ui.theme.radius
import com.amna.ui.R

@Composable
fun CardItem(
    onClick: () -> Unit,
    plantType: String,
    plantName: String,
    plantImage: Painter
) {
    Column(
        modifier = Modifier
            .size(width = 160.dp, height = 168.dp)
            .clip(RoundedCornerShape(MaterialTheme.radius.radius16))
            .background(MaterialTheme.color.cardColor)
            .padding(
                horizontal = MaterialTheme.dimens.dimens8,
                vertical = MaterialTheme.dimens.dimens8
            )
            .clickable { onClick }
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(122.dp)
                .padding(bottom = 22.dp)
                .clip(RoundedCornerShape(MaterialTheme.radius.radius8)),
            painter = plantImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier.padding(bottom = 2.dp),
                text = plantName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.color.textPrimary60
            )
            Spacer(modifier = Modifier.width(48.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
                    .background(MaterialTheme.color.chipColor)
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                text = plantType,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.color.textPrimary60,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}


@Preview
@Composable
fun preview() {
    CardItem(
        onClick = {},
        plantName = "Cacti",
        plantImage = painterResource(id = R.drawable.watering_image),
        plantType = "indoor"
    )
}