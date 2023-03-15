package com.example.affirmations.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.R
import com.example.affirmations.model.Character


@Composable
fun DetailScreen(characterClicked: Character) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(characterClicked.imageDetailResourceId),
            contentDescription = "Background",
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = characterClicked.toString(),
            modifier = Modifier.padding(16.dp)
        )
    }
}
/*
@Preview
@Composable
private fun CharacterPreview() {
    DetailScreen(1)
}*/

