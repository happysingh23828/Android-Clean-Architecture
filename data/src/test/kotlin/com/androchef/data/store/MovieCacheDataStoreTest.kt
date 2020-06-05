package com.androchef.data.store

import com.androchef.data.factory.DataFactory
import com.androchef.data.factory.movie_entity.MovieEntityFactory
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MoviesCache
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieCacheDataStoreTest {

    @Mock
    private lateinit var movieCache: MoviesCache

    private lateinit var movieCacheDataStore: MovieCacheDataStore

    @Before
    fun setUp() {
        movieCacheDataStore = MovieCacheDataStore(movieCache)
    }

    @Test
    fun movieCacheDataStore_saveMovies_completes() {
        // Arrange
        stubMovieCacheSaveMovies(Completable.complete())

        // Act
        val testObserver =
            movieCacheDataStore.saveMovies(MovieEntityFactory.generateDummyMoviesEntities(3)).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun movieCacheDataStore_setMovieBookmarked() {
        // Arrange
        val movieId = DataFactory.getRandomLong()
        stubMovieCacheSetMovieBookMarked(movieId, Completable.complete())

        // Act
        val testObserver = movieCacheDataStore.setMovieBookmarked(movieId).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun movieCacheDataStore_setMovieUnBookmarked() {
        // Arrange
        val movieId = DataFactory.getRandomLong()
        stubMovieCacheSetMovieUnBookMarked(movieId, Completable.complete())

        // Act
        val testObserver = movieCacheDataStore.setMovieUnBookMarked(movieId).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun movieCacheDataStore_getPopularMovies_returnsData() {
        // Arrange
        val movieEntityList = MovieEntityFactory.generateDummyMoviesEntities(5)
        stubMovieCacheGetPopularMovies(Single.just(movieEntityList))

        // Act
        val testObserver = movieCacheDataStore.getPopularMovies().test()

        // Assert
        testObserver.assertValue(movieEntityList)
    }

    @Test
    fun movieCacheDataStore_getBookMarkedMovies_returnsData() {
        // Arrange
        val movieEntityLIst = MovieEntityFactory.generateDummyMoviesEntities(5)
        stubMovieCacheGetBookMarkedMovies(Single.just(movieEntityLIst))

        // Act
        val testObserver = movieCacheDataStore.getBookMarkedMovies().test()

        // Assert
        testObserver.assertValue(movieEntityLIst)
    }

    /**
     * Stub Helper Methods
     */
    private fun stubMovieCacheSaveMovies(completable: Completable) {
        `when`(movieCache.saveMovies(Matchers.anyListOf(MovieEntity::class.java)))
            .thenReturn(completable)
    }

    private fun stubMovieCacheGetPopularMovies(single: Single<List<MovieEntity>>) {
        `when`(movieCache.getPopularMovies())
            .thenReturn(single)
    }

    private fun stubMovieCacheGetBookMarkedMovies(single: Single<List<MovieEntity>>) {
        `when`(movieCache.getBookMarkedMovies())
            .thenReturn(single)
    }

    private fun stubMovieCacheSetMovieBookMarked(movieId: Long, completable: Completable) {
        `when`(movieCache.setMovieBookmarked(movieId))
            .thenReturn(completable)
    }

    private fun stubMovieCacheSetMovieUnBookMarked(movieId: Long, completable: Completable) {
        `when`(movieCache.setMovieUnBookMarked(movieId))
            .thenReturn(completable)
    }
}
