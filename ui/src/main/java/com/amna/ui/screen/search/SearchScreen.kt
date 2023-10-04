package com.amna.ui.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amna.ui.R
import com.amna.ui.theme.Background
import com.amna.ui.theme.CardColor
import com.amna.ui.theme.Primary
import com.amna.ui.theme.Radius
import com.amna.ui.theme.TextPrimary37
import com.amna.ui.theme.TextPrimary87
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SearchScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(TextPrimary87, darkIcons = false)
}

@Composable
fun SearchContent() {
    Column(
        modifier = Modifier
            .background(Background)
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        SearchField("banan", {}, {})
        Spacer(Modifier.height(100.dp))
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 56.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 200.dp, height = 180.dp),
                painter = painterResource(R.drawable.search_placeholder),
                contentDescription = null
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Search about any plant you" +
                        " want to discover it!",
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary37,
                textAlign = TextAlign.Center,
                maxLines = 3
            )
        }
    }
}


@Composable
fun SearchField(
    valueOfFiled: String,
    onTextChange: (String) -> Unit,
    onClickClear: () -> Unit
) {
    TextField(
        value = valueOfFiled,
        onValueChange = onTextChange,
        singleLine = true,
        placeholder = {
            Text(
                text = "Search",
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary37,
            )
        },
        textStyle = TextStyle(color = TextPrimary87),
        modifier = Modifier
            .fillMaxWidth()
            .focusable(enabled = true)
            .border(1.dp, color = Primary, shape = RoundedCornerShape(16.dp)),
        leadingIcon = {
            Icon(painterResource(id = R.drawable.ic_search), contentDescription = "")
        },

        shape = RoundedCornerShape(Radius().radius16),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = CardColor,
            unfocusedContainerColor = CardColor,
            disabledContainerColor = CardColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}


@Preview
@Composable
private fun searchPreview() {
    SearchContent()
}