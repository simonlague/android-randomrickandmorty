package com.simonlague.randomrickandmorty.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.simonlague.randomrickandmorty.MainActivity
import com.simonlague.randomrickandmorty.R
import com.simonlague.randomrickandmorty.network.CharacterRepository
import kotlinx.android.synthetic.main.fragment_character.*

class CharacterFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var changeCharacterButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init ViewModel
        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeCharacterButton = (activity as MainActivity).changeCharacterButton

        changeCharacterButton.setOnClickListener{
            CharacterRepository.getCharacter()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterNameTextView: TextView = tv_characterName

        characterViewModel.characterName.observe(this, Observer {
            characterNameTextView.text = it
        })
    }
}