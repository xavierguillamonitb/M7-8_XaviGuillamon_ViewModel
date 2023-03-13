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

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

}

@Composable
fun DetailScreen(modifier: Modifier, charactersViewModel: CharactersViewModel = viewModel()) {
   // charactersViewModel.loadCharacters()

    val characterUIstate by charactersViewModel.uiState.collectAsState()
    characterUIstate.characterClicked?.let { character ->
        Log.d(TAG, "DetailScreen: $character")
    }

}