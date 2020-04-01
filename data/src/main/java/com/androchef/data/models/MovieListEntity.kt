package com.androchef.data.models

data class MovieListEntity(
    var page: Int = 0,
    var results: MutableList<MovieEntity> = mutableListOf(),
    var total_pages: Int = 0,
    var totalResults: Int = 0
)