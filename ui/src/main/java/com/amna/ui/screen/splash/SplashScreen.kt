package com.amna.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.amna.ui.R
import com.amna.ui.theme.color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SplashScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        MaterialTheme.color.background,
        darkIcons = true
    )
    SplashContent()
}

@Composable
private fun SplashContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = "splash logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(bottom = 2.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.splash_text),
            contentDescription = null
        )
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun preview() {
//    SplashContent()
//}