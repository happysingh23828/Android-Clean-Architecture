package com.androchef.cache.mapper.movies

import com.androchef.cache.models.CachedMovie
import com.androchef.cache.test.factory.cached_movie.CachedMovieFactory
import com.androchef.data.models.MovieEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieEntityMapperTest {

    lateinit var movieEntityMapper: MovieEntityMapper

    @Before
    fun setUp() {
        movieEntityMapper = MovieEntityMapper()
    }

    @Test
    fun mapFromCached() {
        // Arrange
        val cacheMovie = CachedMovieFactory.generateCachedMovie()

        // Act
        val movieEntity = movieEntityMapper.mapFromCached(cacheMovie)

        // Assert
        assertMovieDataEquality(cacheMovie, movieEntity)
    }

    @Test
    fun mapToCache() {
        // Arrange
        val movieEntity = CachedMovieFactory.generateMovieEntity()

        // Act
        val cacheMovie = movieEntityMapper.mapToCached(movieEntity)

        // Assert
        assertMovieDataEquality(cacheMovie, movieEntity)
    }

    private fun assertMovieDataEquality(cachedMovie: CachedMovie, movieEntity: MovieEntity) {
        Assert.assertEquals(movieEntity.id, cachedMovie.movieId)
        Assert.assertEquals(movieEntity.movieName, cachedMovie.name)
        Assert.assertEquals(movieEntity.movieTitle, cachedMovie.title)
        Assert.assertEquals(movieEntity.posterPath, cachedMovie.posterPath)
        Assert.assertEquals(movieEntity.voteAverage, cachedMovie.voteAverage)
        Assert.assertEquals(movieEntity.profilePath, cachedMovie.profilePath)
        Assert.assertEquals(movieEntity.isBookMarked, cachedMovie.isBookMarked)
    }
}
