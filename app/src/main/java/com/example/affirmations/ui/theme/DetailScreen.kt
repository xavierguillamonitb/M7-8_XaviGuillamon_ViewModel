package com.example.affirmations.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.R
import com.example.affirmations.model.Character


@Composable
fun DetailScreen(characterClicked: Character) {
    Box {
        Image(
            painterResource(id = R.drawable.background), contentDescription = null,
            modifier = Modifier.fillMaxSize().alpha(0.5f),
            contentScale = ContentScale.FillHeight

        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = characterClicked.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 24.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Image(
                    painter = painterResource(id = characterClicked.imageResourceId),
                    contentDescription = stringResource(
                        id = characterClicked.stringResourceId
                    ),
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .clip(CutCornerShape(20))
                )
            }
            Text(
                text = stringResource(id = characterClicked.descriptionId),
                modifier = Modifier.padding(16.dp)
            )
            Image(
                painter = painterResource(characterClicked.imageDetailResourceId),
                contentDescription = "Background",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Card",
                        modifier = Modifier.padding(16.dp),
                    )
                    Image(
                        painter = painterResource(id = characterClicked.imageCardId),
                        contentDescription = stringResource(
                            id = characterClicked.stringResourceId
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(500.dp),
                        contentScale = ContentScale.FillHeight,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Card",
                        modifier = Modifier.padding(16.dp),
                    )
                    Image(
                        painter = painterResource(id = characterClicked.imageModelId),
                        contentDescription = stringResource(
                            id = characterClicked.stringResourceId
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(500.dp),
                        contentScale = ContentScale.FillHeight,
                    )
                }
            }
        }

    }
}
/*
@Preview
@Composable
private fun CharacterPreview() {
    DetailScreen(1)
}*/

