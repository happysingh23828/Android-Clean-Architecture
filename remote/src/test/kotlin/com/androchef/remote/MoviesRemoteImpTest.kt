package com.androchef.remote

import com.androchef.remote.factory.movies.RemoteMovieFactory
import com.androchef.remote.mappers.credits.CastResponseEntityMapper
import com.androchef.remote.mappers.credits.CrewResponseEntityMapper
import com.androchef.remote.mappers.credits.MovieCreditResponseEntityMapper
import com.androchef.remote.mappers.movies.MovieModelEntityMapper
import com.androchef.remote.models.movies.MovieListModel
import com.androchef.remote.services.MoviesService
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesRemoteImpTest {

    @Mock
    private lateinit var movieService: MoviesService

    private lateinit var movieModelEntityMapper: MovieModelEntityMapper

    private lateinit var movieCreditResponseMapper: MovieCreditResponseEntityMapper

    private lateinit var movieRemoteImp: MoviesRemoteImp

    @Before
    fun setUp() {
        movieModelEntityMapper = MovieModelEntityMapper()
        movieCreditResponseMapper = MovieCreditResponseEntityMapper(
            CrewResponseEntityMapper(),
            CastResponseEntityMapper()
        )
        movieRemoteImp =
            MoviesRemoteImp(movieService, movieModelEntityMapper, movieCreditResponseMapper)
    }

    @Test
    fun getPopularMovies_Completes() {
        // Arrange
        stubPopularMovies(Single.just(RemoteMovieFactory.generateMovieListModel(6, 0)))

        // Act
        val testObserver = movieRemoteImp.getPopularMovies().test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun getPopularMovies_returnsData() {
        // Arrange
        stubPopularMovies(Single.just(RemoteMovieFactory.generateMovieListModel(6, 0)))

        // Act
        val testObserver = movieRemoteImp.getPopularMovies().test()

        // Assert
        assert(testObserver.values()[0].size == 6)
    }

    /**
     * Stub helpers
     */

    private fun stubPopularMovies(single: Single<MovieListModel>) {
        `when`(movieService.getPopularsMovies()).thenReturn(
            single
        )
    }
}
