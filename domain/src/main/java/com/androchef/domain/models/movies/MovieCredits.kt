package com.androchef.domain.models.movies

data class MovieCredits(
    var cast: List<Cast> = listOf(),
    var crew: List<Crew> = listOf(),
    var id: Int = 0
)
