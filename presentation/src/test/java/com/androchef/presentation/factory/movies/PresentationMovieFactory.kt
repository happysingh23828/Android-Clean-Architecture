package com.androchef.presentation.factory.movies

import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.factory.DataFactory
import com.androchef.presentation.movielist.mapper.MovieMapper
import com.androchef.presentation.movielist.models.MovieView

object PresentationMovieFactory {

    fun generateListOfMovieViews(size: Int): MutableList<MovieView> {
        val listOfMoviesViews = mutableListOf<MovieView>()
        repeat(size) {
            listOfMoviesViews.add(generateMovieView())
        }
        return listOfMoviesViews
    }

    fun generateListOfMovies(size: Int): MutableList<Movie> {
        val listOfMovies = mutableListOf<Movie>()
        repeat(size) {
            listOfMovies.add(generateMovie())
        }
        return listOfMovies
    }

    fun generateMovieView(): MovieView {
        return MovieView(
            id = DataFactory.getRandomLong(),
            voteAverage = DataFactory.getRandomDouble(),
            movieName = DataFactory.getRandomString(),
            isBookMarked = DataFactory.getRandomBoolean(),
            profilePath = MovieMapper.PROFILE_URL_PREFIX.plus(DataFactory.getRandomString())
        )
    }

    fun generateMovie(): Movie {
        return Movie(
            adult = DataFactory.getRandomBoolean(),
            isBookMarked = DataFactory.getRandomBoolean(),
            id = DataFactory.getRandomLong(),
            name = DataFactory.getRandomString(),
            title = DataFactory.getRandomString(),
            vote_average = DataFactory.getRandomDouble(),
            profile_path = DataFactory.getRandomString(),
            poster_path = DataFactory.getRandomString(),
            popularity = DataFactory.getRandomDouble(),
            backdrop_path = DataFactory.getRandomString(),
            first_air_date = DataFactory.getRandomString(),
            genre_ids = listOf(DataFactory.getRandomInt(), DataFactory.getRandomInt()),
            known_for_department = DataFactory.getRandomString(),
            original_language = DataFactory.getRandomString(),
            original_title = DataFactory.getRandomString(),
            overview = DataFactory.getRandomString(),
            release_date = DataFactory.getRandomString(),
            video = DataFactory.getRandomBoolean(),
            vote_count = DataFactory.getRandomInt()
        )
    }
}
