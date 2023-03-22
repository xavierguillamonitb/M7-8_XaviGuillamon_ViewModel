package com.example.affirmations.ui.theme

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.affirmations.model.Character
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharactersViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(Datasource().loadCharacters())
    val uiState: StateFlow<List<Character>> = _uiState.asStateFlow()
}