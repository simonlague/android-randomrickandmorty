package com.simonlague.randomrickandmorty.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.simonlague.randomrickandmorty.R
import com.simonlague.randomrickandmorty.controllers.CharacterController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        setChangerPersonnage()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setChangerPersonnage() {
        button_getCharacter.setOnClickListener {
            CharacterController.changeCharacter(activity!!.applicationContext, character_name, character_image)
        }
    }
}