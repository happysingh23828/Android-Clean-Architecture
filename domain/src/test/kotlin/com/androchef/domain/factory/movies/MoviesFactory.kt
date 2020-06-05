package com.androchef.domain.factory.movies

import com.androchef.domain.factory.DataFactory
import com.androchef.domain.models.movies.Movie

object MoviesFactory {

    fun generateDummyMovieList(size: Int): List<Movie> {
        val movieList = mutableListOf<Movie>()
        repeat(size) {
            movieList.add(generateMovie())
        }
        return movieList
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
