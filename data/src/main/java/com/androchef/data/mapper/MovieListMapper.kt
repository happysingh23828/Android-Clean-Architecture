package com.androchef.data.mapper

import com.androchef.data.models.MovieEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MoviesList

class MovieListMapper : Mapper<MovieListEntity,MoviesList> {

    override fun mapFromEntity(type: MovieListEntity): MoviesList {
        val moviesList = MoviesList()
        type.results.forEach {
            moviesList.results.add(Movie(
                title = it.movieTitle,
                name = it.movieName,
                profile_path = it.profilePath,
                poster_path = it.posterPath,
                vote_average = it.voteAverage,
                isBookMarked = it.isBookMarked
            ))
        }
        return moviesList
    }

    override fun mapToEntity(type: MoviesList): MovieListEntity {
        val movieListEntity = MovieListEntity()
        type.results.forEach {
            movieListEntity.results.add(MovieEntity(
                movieTitle = it.title,
                movieName = it.name,
                profilePath = it.profile_path,
                posterPath = it.poster_path,
                voteAverage = it.vote_average,
                isBookMarked = it.isBookMarked
            ))
        }
        return movieListEntity
    }
}