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
package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Character
/**
 * [Datasource] generates a list of [Character]
 */
class Datasource() {
    fun loadCharacters(): List<Character> {
        return listOf<Character>(
            Character(R.string.character1, R.drawable.image1, R.string.description1, 1),
            Character(R.string.character2, R.drawable.image2, R.string.description2, 2),
            Character(R.string.character3, R.drawable.image3, R.string.description3, 3),
            Character(R.string.character4, R.drawable.image4, R.string.description4,4),
            Character(R.string.character5, R.drawable.image5, R.string.description5,5),
            Character(R.string.character6, R.drawable.image6, R.string.description6,6),
            Character(R.string.character7, R.drawable.image7, R.string.description7,7),
            Character(R.string.character8, R.drawable.image8, R.string.description8,8),
            Character(R.string.character9, R.drawable.image9, R.string.description9,9),
            Character(R.string.character10, R.drawable.image10, R.string.description10,10)
        )
    }
}
