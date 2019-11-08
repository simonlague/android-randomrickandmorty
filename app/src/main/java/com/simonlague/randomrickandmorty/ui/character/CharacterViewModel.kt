package com.simonlague.randomrickandmorty.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simonlague.randomrickandmorty.models.Character

class CharacterViewModel : ViewModel() {

    val mCharacter: MutableLiveData<Character> by lazy {
        MutableLiveData<Character>()
    }
}
