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
            voteAverage = DataFactory.getRandomDouble(),
            profilePath = DataFactory.getRandomString(),
            posterPath = DataFactory.getRandomString(),
            popularity = DataFactory.getRandomDouble(),
            backdropPath = DataFactory.getRandomString(),
            firstAirDate = DataFactory.getRandomString(),
            genreIds = listOf(DataFactory.getRandomInt(), DataFactory.getRandomInt()),
            knownForDepartment = DataFactory.getRandomString(),
            originalLanguage = DataFactory.getRandomString(),
            originalTitle = DataFactory.getRandomString(),
            overview = DataFactory.getRandomString(),
            releaseDate = DataFactory.getRandomString(),
            video = DataFactory.getRandomBoolean(),
            voteCount = DataFactory.getRandomInt()
        )
    }
}
