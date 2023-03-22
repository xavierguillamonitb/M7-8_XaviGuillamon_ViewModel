package com.example.affirmations.ui.theme

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(characterId: Int): ViewModel() {
    private val _uiState = MutableStateFlow(getCharacterFromId(characterId))
    val uiState: StateFlow<Character> = _uiState.asStateFlow()

    private fun getCharacterFromId(id:Int): Character {
        val characterList = Datasource().loadCharacters()

        for(character in characterList)
            if(character.id == id)
                return character
        return Character()
    }
}
