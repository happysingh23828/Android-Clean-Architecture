package com.androchef.presentation.movielist.mapper

import com.androchef.domain.models.movies.Movie
import com.androchef.presentation.factory.movies.PresentationMovieFactory
import com.androchef.presentation.movielist.models.MovieView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieMapperTest {

    private lateinit var movieMapper: MovieMapper

    @Before
    fun setUp() {
        movieMapper = MovieMapper()
    }

    @Test
    fun mapToView() {
        // Arrange
        val movie = PresentationMovieFactory.generateMovie()

        // Act
        val movieView = movieMapper.mapToView(movie)

        // Assert
        assertMovieMapDataEqual(movieView, movie)
    }

    /**
     * Helpers Methods
     */
    private fun assertMovieMapDataEqual(movieView: MovieView, movie: Movie) {
        assertEquals(movieView.profilePath, MovieMapper.PROFILE_URL_PREFIX.plus(movie.posterPath))
        assertEquals(movieView.id, movie.id)
        assertEquals(movieView.isBookMarked, movie.isBookMarked)
        assertEquals(movieView.voteAverage, movie.voteAverage)
        assertEquals(movieView.movieName, movie.title ?: movie.originalTitle)
    }
}
