package com.androchef.remote.mappers.movies

import com.androchef.data.models.MovieEntity
import com.androchef.remote.mappers.EntityMapper
import com.androchef.remote.models.movies.MovieModel

class MovieModelEntityMapper :
    EntityMapper<MovieModel, MovieEntity> {
    override fun mapFromModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            id = model.id,
            movieTitle =  model.title,
            movieName =     model.name,
            posterPath =  model.posterPath,
            profilePath =  model.profile_path,
            voteAverage =  model.voteAverage,
            isBookMarked = false
        )
    }
}