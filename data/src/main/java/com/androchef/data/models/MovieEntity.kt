package com.androchef.data.models

data class MovieEntity (
    var movieTitle : String? ="",
    var movieName : String? ="",
    var voteAverage : Double? = 0.0,
    var profilePath :String? = "",
    var posterPath :String? = ""
)