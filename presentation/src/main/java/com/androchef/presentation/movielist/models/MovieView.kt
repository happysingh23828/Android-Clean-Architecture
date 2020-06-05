package com.androchef.presentation.movielist.models

data class MovieView(
    var id: Long? = 0,
    var movieName: String? = "",
    var voteAverage: Double? = 0.0,
    var profilePath: String? = "",
    var isBookMarked: Boolean
)
