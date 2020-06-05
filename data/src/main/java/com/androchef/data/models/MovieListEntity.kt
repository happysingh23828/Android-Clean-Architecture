package com.androchef.data.models

data class MovieListEntity(
    var page: Int = 0,
    var results: MutableList<MovieEntity> = mutableListOf(),
    var totalPages: Int = 0,
    var totalResults: Int = 0
)
