package com.androchef.remote.mappers.movies

import com.androchef.data.models.MovieEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.remote.mappers.Mapper
import com.androchef.remote.models.movies.MovieListModel
import com.androchef.remote.models.movies.MovieModel

class MovieListResponseMapper(private val movieResponseMapper: MovieResponseMapper) :
    Mapper<MovieListModel, MovieListEntity> {
    override fun mapFromModel(model: MovieListModel): MovieListEntity {
        return MovieListEntity(
            page = model.page,
            total_pages = model.totalPages,
            totalResults = model.totalResults,
            results = model.listOfMoviesResponse .map {
                movieResponseMapper.mapFromModel(it)
            }.toMutableList()
        )
    }


    inner class MovieResponseMapper :
        Mapper<MovieModel, MovieEntity> {
        override fun mapFromModel(model: MovieModel): MovieEntity {
            return MovieEntity(
                movieTitle =  model.title,
                movieName =  model.name,
                posterPath =  model.posterPath,
                profilePath =  model.profile_path,
                voteAverage =  model.voteAverage,
                isBookMarked = false
            )
        }
    }
}