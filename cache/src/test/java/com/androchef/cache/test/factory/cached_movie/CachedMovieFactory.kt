package com.androchef.cache.test.factory.cached_movie

import com.androchef.cache.models.CachedMovie
import com.androchef.cache.test.factory.DataFactory
import com.androchef.data.models.MovieEntity

object CachedMovieFactory {

    fun generateListOfCachedMovie(size: Int): MutableList<CachedMovie> {
        val listOfCachedMovie = mutableListOf<CachedMovie>()
        repeat(size) {
            listOfCachedMovie.add(generateCachedMovie())
        }
        return listOfCachedMovie
    }

    fun generateListOfMovieEntities(size: Int): MutableList<MovieEntity> {
        val listOfMovieEntities = mutableListOf<MovieEntity>()
        repeat(size) {
            listOfMovieEntities.add(generateMovieEntity())
        }
        return listOfMovieEntities
    }

    fun generateListOfMovieEntitiesWithNotBookmark(size: Int): MutableList<MovieEntity> {
        val listOfMovieEntities = mutableListOf<MovieEntity>()
        repeat(size) {
            val movieEntity = generateMovieEntity()
            movieEntity.isBookMarked = false
            listOfMovieEntities.add(movieEntity)
        }
        return listOfMovieEntities
    }

    fun generateCachedMovie(): CachedMovie {
        return CachedMovie(
            movieId = DataFactory.getRandomLong(),
            posterPath = DataFactory.getRandomString(),
            profilePath = DataFactory.getRandomString(),
            voteAverage = DataFactory.getRandomDouble(),
            isBookMarked = DataFactory.getRandomBoolean(),
            title = DataFactory.getRandomString(),
            name = DataFactory.getRandomString()
        )
    }

    fun generateMovieEntity(): MovieEntity {
        return MovieEntity(
            id = DataFactory.getRandomLong(),
            posterPath = DataFactory.getRandomString(),
            profilePath = DataFactory.getRandomString(),
            voteAverage = DataFactory.getRandomDouble(),
            isBookMarked = DataFactory.getRandomBoolean(),
            movieTitle = DataFactory.getRandomString(),
            movieName = DataFactory.getRandomString()
        )
    }
}
