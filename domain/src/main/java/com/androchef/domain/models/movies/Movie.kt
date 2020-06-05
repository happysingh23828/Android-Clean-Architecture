package com.androchef.domain.models.movies

data class Movie(
    var adult: Boolean = false,
    var backdropPath: String? = "",
    var name: String? = "",
    var genreIds: List<Int> = listOf(),
    var id: Long? = 0,
    var originalLanguage: String = "",
    var originalTitle: String? = "",
    var overview: String = "",
    var popularity: Double = 0.0,
    var posterPath: String? = "",
    var releaseDate: String? = "",
    var firstAirDate: String? = "",
    var title: String? = "",
    var knownForDepartment: String = "",
    var profilePath: String? = "",
    var video: Boolean = false,
    var voteAverage: Double? = 0.0,
    var voteCount: Int = 0,
    var isBookMarked: Boolean

)
