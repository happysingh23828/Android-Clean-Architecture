package com.androchef.data.mapper

import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MoviesList

class MovieMapper : Mapper<List<MovieEntity>,MoviesList> {

    override fun mapFromEntity(type: List<MovieEntity>): MoviesList {
        val moviesList = MoviesList()
        type.forEach {
            moviesList.results.add(Movie(
                title = it.movieTitle,
                name = it.movieName,
                profile_path = it.profilePath,
                poster_path = it.posterPath,
                vote_average = it.voteAverage
                ))
        }
        return moviesList
    }

    override fun mapToEntity(type: MoviesList): List<MovieEntity> {
        val listOfMovies = mutableListOf<MovieEntity>()
        type.results.forEach {
            listOfMovies.add(MovieEntity(
                movieTitle = it.title,
                movieName = it.name,
                posterPath = it.poster_path,
                profilePath = it.profile_path,
                voteAverage = it.vote_average
            ))
        }
        return  listOfMovies
    }
}