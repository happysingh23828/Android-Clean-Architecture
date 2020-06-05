package com.androchef.data.models

data class MovieCreditEntity(
    var cast: List<CastEntity> = listOf(),
    var crew: List<CrewEntity> = listOf(),
    var id: Int = 0
)
