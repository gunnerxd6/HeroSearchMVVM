package cl.phobos.superheroessearch.heroSearch.data.network.response

import com.google.gson.annotations.SerializedName

data class HeroResponse (
    val response: String,
    val resultsFor: String,
    val results: List<Result>
)

data class Result (
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

data class Appearance (
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

data class Biography (
    @SerializedName("full-name")
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Connections (
    val groupAffiliation: String,
    val relatives: String
)

data class Image (
    val url: String
)

data class Powerstats (
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Work (
    val occupation: String,
    val base: String
)
