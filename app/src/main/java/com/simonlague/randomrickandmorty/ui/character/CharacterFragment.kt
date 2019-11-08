package com.simonlague.randomrickandmorty.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.simonlague.randomrickandmorty.MainActivity
import com.simonlague.randomrickandmorty.R
import com.simonlague.randomrickandmorty.models.Character
import com.simonlague.randomrickandmorty.network.CharacterRepository
import com.simonlague.randomrickandmorty.util.GlideApp
import kotlinx.android.synthetic.main.fragment_character.*

class CharacterFragment : Fragment() {

    companion object {
        fun newInstance() = CharacterFragment()
    }

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterNameTextView: TextView
    private lateinit var characterPictureImageView: ImageView
    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init ViewModel
        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        characterNameTextView = tv_characterName
        characterPictureImageView = iv_character_image
        setCharacterObserver()
        setChangePostButtonClick()
    }

    private fun setChangePostButtonClick() {
        (activity as MainActivity).changeCharacterButton.setOnClickListener {
//            character = CharacterRepository.getMockCharacter()
            characterViewModel.mCharacter.setValue(character)
        }
    }

    // Create the observer which updates the UI.
    private fun setCharacterObserver() {
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        characterViewModel.mCharacter.observe(this, Observer<Character> { newCharacter ->
            // Update the UI, in this case, a TextView.
            characterNameTextView.text = newCharacter.name
            Log.d("character", newCharacter.toString())
            GlideApp.with(this).load(character.image).into(characterPictureImageView)
        })
    }
}