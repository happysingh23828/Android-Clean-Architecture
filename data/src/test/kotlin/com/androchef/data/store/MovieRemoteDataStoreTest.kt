package com.androchef.data.store

import com.androchef.data.factory.DataFactory
import com.androchef.data.factory.movie_entity.MovieEntityFactory
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MoviesRemote
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRemoteDataStoreTest {

    @Mock
    private lateinit var movieRemote: MoviesRemote

    private lateinit var movieRemoteDataStore: MovieRemoteDataStore

    @Before
    fun setUp() {
        movieRemoteDataStore = MovieRemoteDataStore(movieRemote)
    }

    @Test
    fun movieRemoteDataStore_getPopularMovies_returnsData() {
        // Arrange
        val movieList = MovieEntityFactory.generateDummyMoviesEntities(5)
        stubMovieRemoteGetPopularMovies(Single.just(movieList))

        // Act
        val testObserver = movieRemoteDataStore.getPopularMovies().test()

        // Assert
        testObserver.assertValue(movieList)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun movieRemoteDataStore_getBookMarkedMovies_exception() {
        // Act
        movieRemoteDataStore.getBookMarkedMovies().test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun movieRemoteDataStore_setMovieBookmarked_exception() {
        // Arrange
        val movieId = DataFactory.getRandomLong()

        // Act
        movieRemoteDataStore.setMovieBookmarked(movieId).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun movieRemoteDataStore_setMovieUnBookmarked_exception() {
        // Arrange
        val movieId = DataFactory.getRandomLong()

        // Act
        movieRemoteDataStore.setMovieUnBookMarked(movieId).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun movieRemoteDataStore_saveMovies_exception() {
        // Arrange
        val moviesList = MovieEntityFactory.generateDummyMoviesEntities(4)

        // Act
        movieRemoteDataStore.saveMovies(moviesList).test()
    }

    /**
     * Stub Helper methods
     */
    private fun stubMovieRemoteGetPopularMovies(single: Single<List<MovieEntity>>) {
        `when`(movieRemote.getPopularMovies())
            .thenReturn(single)
    }
}
