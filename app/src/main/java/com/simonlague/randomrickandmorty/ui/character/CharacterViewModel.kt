package com.simonlague.randomrickandmorty.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    private val mCharacterName = MutableLiveData<String>()
    private val mImageUrl = MutableLiveData<String>()

    val characterName: LiveData<String> = mCharacterName
    val imageUrl: LiveData<String> = mImageUrl
}
