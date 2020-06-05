package com.androchef.remote.mappers.movies

import com.androchef.data.models.MovieEntity
import com.androchef.remote.factory.movies.RemoteMovieFactory
import com.androchef.remote.models.movies.MovieModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieModelEntityMapperTest {

    private lateinit var movieModelEntityMapper: MovieModelEntityMapper

    @Before
    fun setUp() {
        movieModelEntityMapper = MovieModelEntityMapper()
    }

    @Test
    fun mapFromModel() {
        // Arrange
        val movieModel = RemoteMovieFactory.generateMovieModel()

        // Act
        val movieEntity = movieModelEntityMapper.mapFromModel(movieModel)

        // Assert
        assertMapMovieDataEquals(movieModel, movieEntity)
    }

    /**
     * Helper Methods
     */
    private fun assertMapMovieDataEquals(movieModel: MovieModel, movieEntity: MovieEntity) {
        assertEquals(movieEntity.isBookMarked, false)
        assertEquals(movieEntity.profilePath, movieModel.profilePath)
        assertEquals(movieEntity.voteAverage, movieModel.voteAverage)
        assertEquals(movieEntity.movieTitle, movieModel.title)
        assertEquals(movieEntity.movieName, movieModel.name)
        assertEquals(movieEntity.posterPath, movieModel.posterPath)
    }
}
