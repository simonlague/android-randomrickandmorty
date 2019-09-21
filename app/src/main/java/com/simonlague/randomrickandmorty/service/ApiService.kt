package com.simonlague.randomrickandmorty.service

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.simonlague.randomrickandmorty.domain.Character

class ApiService {

    fun getCharacter(context: Context): Character? {
        val queue = Volley.newRequestQueue(context)
        val url = "https://rickandmortyapi.com/api/"
        val path = "character/"
        var character: Character? = null

        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url + path, null,
            Response.Listener { response ->

                Log.d("REPONSE", response.toString())

                character = Gson().fromJson(response.toString(), Character::class.java)

                Log.d("PARSED_REPONSE", character.toString())

            },
            Response.ErrorListener { error ->
                Log.e("ERREUR", error.toString())
                // TODO: Handle error
            }
        )
        queue.add(stringRequest)
        return character
    }
}