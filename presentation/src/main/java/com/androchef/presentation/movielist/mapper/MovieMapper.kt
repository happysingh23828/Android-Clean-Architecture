package com.androchef.presentation.movielist.mapper

import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.mapper.Mapper
import com.androchef.presentation.movielist.models.MovieView
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<MovieView, Movie> {

    private val profileUrlPrefix = "https://image.tmdb.org/t/p/w185"

    override fun mapToView(type: Movie): MovieView {
        return MovieView(
            id = type.id,
            profilePath = profileUrlPrefix.plus(type.poster_path),
            movieName = type.title ?: type.original_title,
            isBookMarked = type.isBookMarked,
            voteAverage = type.vote_average
        )
    }
}