package com.androchef.data.models

import com.sun.org.apache.xpath.internal.operations.Bool

data class MovieEntity (
    var movieTitle : String? ="",
    var movieName : String? ="",
    var voteAverage : Double? = 0.0,
    var profilePath :String? = "",
    var posterPath :String? = "",
    var isBookMarked : Boolean
)