package com.simonlague.randomrickandmorty.service

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.simonlague.randomrickandmorty.R
import com.simonlague.randomrickandmorty.domain.Character
import org.json.JSONObject

class ApiService {

    private var character: Character? = null

    fun getCharacter(context: Context): Character? {
        Log.d("GET_CHARACTER", "Appel de l'API")

        val queue = Volley.newRequestQueue(context)
        val url = "https://rickandmortyapi.com/api/"
        val path = "character/2"

        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url + path, null,
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