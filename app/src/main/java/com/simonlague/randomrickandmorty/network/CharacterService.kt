package com.simonlague.randomrickandmorty.network

import com.simonlague.randomrickandmorty.models.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("/character/{id}")
    fun getCharacter(@Path("id") id: String): Call<Character>
}