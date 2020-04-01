package com.androchef.remote.mappers

import com.androchef.data.models.MovieEntity
import com.androchef.remote.models.MovieModel

class MovieListResponseMapper : Mapper<MovieModel,MovieEntity> {
    override fun mapFromModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            movieTitle = model.title,
            movieName = model.name,
            profilePath = model.profile_path,
            posterPath = model.posterPath,
            isBookMarked = false
        )
    }
}