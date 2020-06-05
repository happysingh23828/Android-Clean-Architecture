package com.androchef.data.factory.movie_entity

import com.androchef.data.factory.DataFactory
import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie

object MovieEntityFactory {

    fun generateDummyMoviesEntities(size: Int): List<MovieEntity> {
        val mutableMovieEntityList = mutableListOf<MovieEntity>()
        repeat(size) {
            mutableMovieEntityList.add(generateMovieEntity())
        }

        return mutableMovieEntityList
    }

    fun generateDummyMovieList(size: Int): List<Movie> {
        val movieList = mutableListOf<Movie>()
        repeat(size) {
            movieList.add(generateMovie())
        }
        return movieList
    }

    fun generateMovieEntity(): MovieEntity {
        return MovieEntity(
            id = DataFactory.getRandomLong(),
            isBookMarked = DataFactory.getRandomBoolean(),
            voteAverage = DataFactory.getRandomDouble(),
            movieName = DataFactory.getRandomString(),
            profilePath = DataFactory.getRandomString(),
            posterPath = DataFactory.getRandomString(),
            movieTitle = DataFactory.getRandomString()
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
