package com.amna.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.amna.ui.theme.Dimens
@Composable
fun Pager(
    onBoardingPage: PlantPagerState, contentDescription: String
) {
    Column(Modifier.fillMaxSize()) {
        FitImage(
            modifier = Modifier
                .padding(horizontal = Dimens().dimens16)
                .fillMaxWidth(),
            image = painterResource(id = onBoardingPage.imageResource),
            contentDescription = contentDescription
        )
        Text(
            modifier = Modifier.padding(
                top = Dimens().dimens16,
                start = Dimens().dimens16,
                end = Dimens().dimens16
            ),
            text = onBoardingPage.title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Gray
        )
        Text(
            modifier = Modifier.padding(
                top = Dimens().dimens16,
                start = Dimens().dimens16,
                end = Dimens().dimens16
            ),
            text = "",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun OnboardingOne() {
    Pager(PlantPagerState.First, "")
}

@Preview
@Composable
fun OnboardingTwo() {
    Pager(PlantPagerState.Second, "")
}


@Preview
@Composable
fun OnboardingThree() {
    Pager(PlantPagerState.Third, "")
}