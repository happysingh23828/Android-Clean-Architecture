package com.androchef.domain.models.movies

data class MoviesList(
    var page: Int = 0,
    var results: MutableList<Movie> = mutableListOf(),
    var totalPages: Int = 0,
    var totalResults: Int = 0
)
