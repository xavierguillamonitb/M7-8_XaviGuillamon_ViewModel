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
package com.example.affirmations.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
/**
 * [Character] is the data class to represent the Affirmation text and imageResourceId
 */
data class Character(
    @StringRes val stringResourceId: Int = 0,
    @DrawableRes val imageResourceId: Int = 0,
    @DrawableRes val imageCardId: Int = 0,
    @DrawableRes val imageModelId: Int = 0,
    @DrawableRes val imageDetailResourceId: Int = 0,
    @StringRes val descriptionId: Int = 0,
    val id: Int = 0,
    val phone: String = "675642765",
    val email: String = "x.guillamonsalinas@itb.cat",
    val emailTo: String = "messimessimessi@god.ar"
)