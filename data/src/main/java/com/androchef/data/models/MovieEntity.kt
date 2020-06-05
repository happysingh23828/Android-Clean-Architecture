package com.androchef.data.models

data class MovieEntity(
    var id: Long? = 0,
    var movieTitle: String? = "",
    var movieName: String? = "",
    var voteAverage: Double? = 0.0,
    var profilePath: String? = "",
    var posterPath: String? = "",
    var isBookMarked: Boolean
)
