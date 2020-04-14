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

    fun generateDummyMovieList(size: Int) : List<Movie> {
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