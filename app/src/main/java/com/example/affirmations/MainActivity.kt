/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Character
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationApp()
        }
    }
}
@Composable
fun AffirmationApp() {
    AffirmationsTheme() {
        val count = rememberSaveable { mutableStateOf(0) }
        Column() {
            TextButton(onClick = { count.value += 1 }) {
                Text(text = "You clicked me ${count.value} times")
            }
            AffirmationList(affirmationList = Datasource().loadCharacters())
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Character>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(affirmationList.count()) { element ->
            AffirmationCard(character = affirmationList[element])
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
fun AffirmationCard(character: Character, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(15.dp),
        ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = character.imageResourceId),
                    contentDescription = stringResource(
                        id = character.stringResourceId
                    ),
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .clip(CutCornerShape(20))
                )
                Text(
                    text = stringResource(id = character.stringResourceId),
                    modifier = Modifier
                        .weight(1f)
                )
                DropDownButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) DescriptionsInCard(desCard = character.descriptionId, characterId = character.id)
        }
    }
}

@Composable
private fun DropDownButton(
    expanded: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.descriptionIcon)
        )
    }
}

@Composable
fun DescriptionsInCard(
    @StringRes desCard: Int, modifier: Modifier = Modifier, characterId: Int
) {
    val activity = LocalContext.current as MainActivity
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(id = desCard),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Button(onClick = {
            val myIntent = Intent(activity, DetailActivity::class.java)
            myIntent.putExtra("id", characterId)
            activity.startActivity(myIntent)
        }) {
            Text(text = "See More")
        }
    }
}