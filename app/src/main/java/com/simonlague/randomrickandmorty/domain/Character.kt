package com.simonlague.randomrickandmorty.domain

import java.util.*

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episodes: Array<String>,
    val url: String,
    val date: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Character

        if (id != other.id) return false
        if (name != other.name) return false
        if (status != other.status) return false
        if (species != other.species) return false
        if (type != other.type) return false
        if (gender != other.gender) return false
        if (origin != other.origin) return false
        if (location != other.location) return false
        if (image != other.image) return false
        if (!episodes.contentEquals(other.episodes)) return false
        if (url != other.url) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + episodes.contentHashCode()
        result = 31 * result + url.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}