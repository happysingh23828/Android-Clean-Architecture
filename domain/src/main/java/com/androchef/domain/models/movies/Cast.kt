package com.androchef.domain.models.movies

data class Cast(
    var character: String = "",
    var id: Int = 0,
    var name: String = "",
    var order: Int = 0,
    var profilePath: String = ""
)
