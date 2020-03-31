package com.androchef.domain.models.movies

data class MoviesList(
    var page: Int = 0,
    var results: List<Movie> = listOf(),
    var total_pages: Int = 0,
    var totalResults: Int = 0
)