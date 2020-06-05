package com.androchef.data.mapper.movielist

import com.androchef.data.factory.movie_entity.MovieEntityFactory
import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieMapperTest {

    private lateinit var movieMapper: MovieMapper

    @Before
    fun setUp() {
        movieMapper = MovieMapper()
    }

    @Test
    fun mapFromEntity() {
        // Arrange
        val movieEntity = MovieEntityFactory.generateMovieEntity()

        // Act
        val movie = movieMapper.mapFromEntity(movieEntity)

        // Assert
        assertMovieDataEquality(movieEntity, movie)
    }

    @Test
    fun mapToEntity() {
        // Arrange
        val movie = MovieEntityFactory.generateMovie()

        // Act
        val movieEntity = movieMapper.mapToEntity(movie)

        // Assert
        assertMovieDataEquality(movieEntity, movie)
    }

    /**
     * Helper Methods
     */
    private fun assertMovieDataEquality(movieEntity: MovieEntity, movie: Movie) {
        assertEquals(movieEntity.id, movie.id)
        assertEquals(movieEntity.movieName, movie.name)
        assertEquals(movieEntity.movieTitle, movie.title)
        assertEquals(movieEntity.posterPath, movie.poster_path)
        assertEquals(movieEntity.voteAverage, movie.vote_average)
        assertEquals(movieEntity.profilePath, movie.profile_path)
        assertEquals(movieEntity.isBookMarked, movie.isBookMarked)
    }
}
