package com.amna.ui.screen.plantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amna.ui.R
import com.amna.ui.composable.BoxWithIconAndText
import com.amna.ui.composable.ChipItem
import com.amna.ui.theme.Dimens
import com.amna.ui.theme.Poppins
import com.amna.ui.theme.color

@Composable
fun PlantDetailsScreen() {
    PlantDetailsContent(
        plantImage = painterResource(id = R.drawable.watering_image),
        plantType = "indoor",
        plantName = "gjjjj gugug",
        scientificName = "hgfhkfffk hhi"
    )
}

@Composable
fun PlantDetailsContent(
    plantImage: Painter,
    plantName: String,
    scientificName: String,
    plantType: String
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.background)
    ) {
        item {
            Image(
                modifier = Modifier
                    .height(430.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 100.dp)),
                contentScale = ContentScale.Crop,
                painter = plantImage,
                contentDescription = null
            )
        }
        item {
            Spacer(modifier = Modifier.height(Dimens().dimens16))
        }
        item {
            Text(
                text = plantName,
                fontSize = 18.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(Dimens().dimens8))
        }
        item {
            Text(
                text = "Scientific name:$scientificName",
                fontSize = 10.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(Dimens().dimens16))
        }
        item {
            ChipItem(text = plantType,
                modifier = Modifier.padding(start = 16.dp),
                onClickChip = {}
            )
        }
        item {
            Spacer(modifier = Modifier.height(Dimens().dimens24))
        }
        item {
            Text(
                text = "What do you know about this plant?",
                fontFamily = Poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BoxWithIconAndText(
                    icon = painterResource(id = R.drawable.ic_waterdrops),
                    text = "Watering",
                    onClickBox = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
                BoxWithIconAndText(
                    icon = painterResource(id = R.drawable.ic_sun),
                    text = "Sunlight",
                    onClickBox = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
                BoxWithIconAndText(
                    icon = painterResource(id = R.drawable.ic_scissors),
                    text = "Pruning",
                    onClickBox = {}
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(56.dp))
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun preview() {
    PlantDetailsScreen()
}