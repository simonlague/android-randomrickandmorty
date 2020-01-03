package com.simonlague.randomrickandmorty.network

import android.util.Log
import com.simonlague.randomrickandmorty.mocks.CharacterMock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.simonlague.randomrickandmorty.models.Character
import com.simonlague.randomrickandmorty.util.getRandomCharacterId

object CharacterRepository {

    private val characterService: CharacterService = RetrofitService.createService(CharacterService::class.java)

    fun getCharacter() {
        Log.d("getCharacter()", "APPEL_API")

        characterService.getCharacter(getRandomCharacterId().toString()).enqueue(
            object : Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    Log.d("CHARACTER", "onResponse")

                    val character = response.body()

                    Log.d("CHARACTER", character.toString())

                    if (character != null) {
                        Log.d("CHARACTER", "OK")
                    }
                }
                override fun onFailure(call: Call<Character>, t: Throwable) {
                    error("KO")
                }
            }
        )
    }

    fun getMockCharacter(): Character {
        return CharacterMock.getCharacter()
    }
}