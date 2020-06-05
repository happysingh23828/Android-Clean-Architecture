package com.androchef.presentation.movielist.mapper

import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.mapper.Mapper
import com.androchef.presentation.movielist.models.MovieView
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<MovieView, Movie> {

    override fun mapToView(type: Movie): MovieView {
        return MovieView(
            id = type.id,
            profilePath = PROFILE_URL_PREFIX.plus(type.poster_path),
            movieName = type.title ?: type.original_title,
            isBookMarked = type.isBookMarked,
            voteAverage = type.vote_average
        )
    }

    companion object {
        const val PROFILE_URL_PREFIX = "https://image.tmdb.org/t/p/w185"
    }
}
