package com.simonlague.randomrickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.simonlague.randomrickandmorty.service.ApiService
import android.widget.ImageView
import com.simonlague.randomrickandmorty.domain.Character
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var buttonGetCharacter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = ApiService()
        textView = findViewById(R.id.character_name)
        imageView = findViewById(R.id.character_image)
        buttonGetCharacter = findViewById(R.id.button_getCharacter)

        buttonGetCharacter.setOnClickListener {
            changeCharacter()
        }
    }

    private fun changeCharacter() {
        val character = getCharacter()
        if (character != null) {
            textView.text = character.name
            Picasso.get().load(character.image).into(imageView)
        }
    }

    private fun getCharacter(): Character? {
        return apiService.getCharacter(this)
    }
}
