package com.androchef.cache.mapper.movies

import com.androchef.cache.mapper.EntityMapper
import com.androchef.cache.models.CachedMovie
import com.androchef.data.models.MovieEntity

class MovieEntityMapper : EntityMapper<CachedMovie,MovieEntity> {
    override fun mapFromCached(type: CachedMovie): MovieEntity {
        return  MovieEntity(
            id = type.id,
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
            id = type.id!!,
            name = type.movieName,
            title = type.movieTitle,
            posterPath = type.posterPath,
            profilePath = type.profilePath,
            isBookMarked = type.isBookMarked
        )
    }
}