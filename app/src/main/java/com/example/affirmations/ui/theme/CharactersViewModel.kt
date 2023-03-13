package com.example.affirmations.ui.theme

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.affirmations.model.Character
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharactersViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(CharactersUIState(null))
    val uiState: StateFlow<CharactersUIState> = _uiState.asStateFlow()

    fun loadCharacters(id:Int) {
        val characterList = Datasource().loadCharacters()

        val character = characterList.firstOrNull { it.id == id }  // TODO calcular el que corresponde

        _uiState.value = CharactersUIState(character)
    }
}
class CharactersUIState(
    val characterClicked: Character?
)