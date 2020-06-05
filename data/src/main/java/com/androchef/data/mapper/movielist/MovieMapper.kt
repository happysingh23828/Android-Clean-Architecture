package com.androchef.data.mapper.movielist

import com.androchef.data.mapper.Mapper
import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() :
    Mapper<MovieEntity, Movie> {

    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(
            id = type.id,
            title = type.movieTitle,
            name = type.movieName,
            posterPath = type.posterPath,
            profilePath = type.profilePath,
            voteAverage = type.voteAverage,
            isBookMarked = type.isBookMarked
        )
    }

    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(
            id = type.id,
            movieTitle = type.title,
            movieName = type.name,
            posterPath = type.posterPath,
            profilePath = type.profilePath,
            voteAverage = type.voteAverage,
            isBookMarked = type.isBookMarked
        )
    }
}
