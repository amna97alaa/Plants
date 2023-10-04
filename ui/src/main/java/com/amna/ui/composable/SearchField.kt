package com.amna.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.amna.ui.R
import com.amna.ui.theme.CardColor
import com.amna.ui.theme.Primary
import com.amna.ui.theme.Radius
import com.amna.ui.theme.TextPrimary37
import com.amna.ui.theme.TextPrimary87

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