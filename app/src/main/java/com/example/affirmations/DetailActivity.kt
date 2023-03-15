package com.example.affirmations

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.affirmations.ui.theme.CharactersViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.affirmations.ui.theme.DetailScreen

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val characterId = intent.getIntExtra("id", 0)
        setContent {
            DetailScreen(characterId = characterId)
        }
    }

}

@Composable
fun DetailScreen(charactersViewModel: CharactersViewModel = viewModel(), characterId: Int) {
    val characterUIstate by charactersViewModel.uiState.collectAsState()
    charactersViewModel.loadCharacters(characterId)
    characterUIstate.characterClicked?.let { character ->
        DetailScreen(characterClicked = character)
    }
}