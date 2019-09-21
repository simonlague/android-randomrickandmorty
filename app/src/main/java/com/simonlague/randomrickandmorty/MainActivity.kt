package com.simonlague.randomrickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simonlague.randomrickandmorty.service.ApiService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiService()
        apiService.getCharacter(this)

    }
}
