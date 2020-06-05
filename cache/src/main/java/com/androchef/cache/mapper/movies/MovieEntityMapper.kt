package com.androchef.cache.mapper.movies

import com.androchef.cache.mapper.EntityMapper
import com.androchef.cache.models.CachedMovie
import com.androchef.data.models.MovieEntity
import javax.inject.Inject

class MovieEntityMapper @Inject constructor() : EntityMapper<CachedMovie, MovieEntity> {
    override fun mapFromCached(type: CachedMovie): MovieEntity {
        return MovieEntity(
            id = type.movieId,
            movieTitle = type.title,
            movieName = type.name,
            posterPath = type.posterPath,
            profilePath = type.profilePath,
            voteAverage = type.voteAverage,
            isBookMarked = type.isBookMarked
        )
    }

    override fun mapToCached(type: MovieEntity): CachedMovie {
        return CachedMovie(
            movieId = type.id!!,
            name = type.movieName,
            title = type.movieTitle,
            posterPath = type.posterPath,
            profilePath = type.profilePath,
            isBookMarked = type.isBookMarked,
            voteAverage = type.voteAverage
            )
    }
}
