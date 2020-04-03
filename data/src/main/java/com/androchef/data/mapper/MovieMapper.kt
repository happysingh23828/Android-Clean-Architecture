package com.androchef.data.mapper

import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie

class MovieMapper : Mapper<MovieEntity, Movie> {

    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(
            id = type.id,
            title = type.movieTitle,
            name = type.movieName,
            poster_path = type.posterPath,
            profile_path = type.profilePath,
            vote_average = type.voteAverage,
            isBookMarked = type.isBookMarked
        )
    }

    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(
            id = type.id,
            movieTitle = type.title,
            movieName = type.name,
            posterPath = type.poster_path,
            profilePath = type.profile_path,
            voteAverage = type.vote_average,
            isBookMarked = type.isBookMarked
        )
    }
}