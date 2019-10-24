package com.simonlague.randomrickandmorty.controllers

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.simonlague.randomrickandmorty.models.Character
import com.squareup.picasso.Picasso

object CharacterController {

    private var character: Character? = null

    fun changeCharacter(context: Context, textView: TextView, imageView: ImageView) {
        if (character != null) {
            textView.text = character!!.name
            Picasso.get().load(character!!.image).into(imageView)
        }
    }
}