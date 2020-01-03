package com.simonlague.randomrickandmorty.mocks

import com.simonlague.randomrickandmorty.models.Character
import com.simonlague.randomrickandmorty.models.Location
import com.simonlague.randomrickandmorty.models.Origin

object CharacterMock {
    fun getCharacter(): Character {
        return Character(
            1,
        "nameMock",
        "statusMock",
        "speciesMock",
        "type",
        "gender",
        Origin("originNameMock", "originUrlMock"),
        Location("locationNameMock", "locationUrlMock"),
        "imageMock",
        Array(3, ),
        "urlMock",
        "createdMock"
        )
    }
}