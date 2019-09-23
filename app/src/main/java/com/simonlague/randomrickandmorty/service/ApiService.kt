package com.simonlague.randomrickandmorty.service

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.simonlague.randomrickandmorty.models.Character
import com.simonlague.randomrickandmorty.util.getRandomCharacterIdToString

object ApiService {

    fun getCharacter(context: Context): Character? {
        Log.d("GET_CHARACTER", "Appel de l'API")

        val queue = Volley.newRequestQueue(context)
        val url = "https://rickandmortyapi.com/api/"
        val path = "character/"
        var character: Character? = null
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url + path + getRandomCharacterIdToString(), null,
            Response.Listener { response ->
                character = Gson().fromJson(response.toString(), Character::class.java)
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