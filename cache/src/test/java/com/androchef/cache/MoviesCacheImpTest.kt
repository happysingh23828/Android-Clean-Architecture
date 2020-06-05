package com.androchef.cache

import androidx.room.Room
import com.androchef.cache.db.MovieDatabase
import com.androchef.cache.mapper.movies.MovieEntityMapper
import com.androchef.cache.test.factory.cached_movie.CachedMovieFactory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MoviesCacheImpTest {

    private lateinit var movieDatabase: MovieDatabase

    private lateinit var movieEntityMapper: MovieEntityMapper

    private lateinit var preferencesHelper: PreferencesHelper

    private lateinit var moviesCacheImp: MoviesCacheImp

    @Before
    fun setUp() {
        preferencesHelper = PreferencesHelper(RuntimeEnvironment.application)
        movieEntityMapper = MovieEntityMapper()
        movieDatabase = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.baseContext,
            MovieDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        moviesCacheImp = MoviesCacheImp(movieDatabase, movieEntityMapper, preferencesHelper)
    }

    @Test
    fun saveMovies_completes() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntities(7)

        // Act
        val testObserver = moviesCacheImp.saveMovies(movieEntities).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun saveMovies_dataSaved() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntities(7)

        // Act
        moviesCacheImp.saveMovies(movieEntities).test()

        // Assert
        val cachedMovies = movieDatabase.cachedMovieDao().getMovies()
        assert(cachedMovies.size == movieEntities.size)
    }

    @Test
    fun getPopularMovies_returnsData() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntities(7)
        moviesCacheImp.saveMovies(movieEntities).test()

        // Act
        val testObserver = moviesCacheImp.getPopularMovies().test()

        // Assert
        assert(testObserver.values()[0].size == movieEntities.size)
    }

    @Test
    fun getPopularMovies_completes() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntities(7)
        moviesCacheImp.saveMovies(movieEntities).test()

        // Act
        val testObserver = moviesCacheImp.getPopularMovies().test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun getBookMarkedMovies_completes() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntitiesWithNotBookmark(7)
        moviesCacheImp.saveMovies(movieEntities).test()

        // Act
        val testObserver = moviesCacheImp.getBookMarkedMovies().test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun getBookMarkedMovies_returnData() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntitiesWithNotBookmark(7)
        // Only bookmarking one movie
        movieEntities[0].isBookMarked = true
        moviesCacheImp.saveMovies(movieEntities).test()

        // Act
        val testObserver = moviesCacheImp.getBookMarkedMovies().test()

        // Assert
        assert(testObserver.values()[0].size == 1)
    }

    @Test
    fun setMovieBookmarked_completes() {
        // Arrange
        val movieEntity = CachedMovieFactory.generateMovieEntity()
        movieEntity.isBookMarked = false
        moviesCacheImp.saveMovies(listOf(movieEntity))

        // Act
        val testObserver = moviesCacheImp.setMovieBookmarked(movieEntity.id!!).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun setUnMovieBookmarked_completes() {
        // Arrange
        val movieEntity = CachedMovieFactory.generateMovieEntity()
        movieEntity.isBookMarked = true
        moviesCacheImp.saveMovies(listOf(movieEntity))

        // Act
        val testObserver = moviesCacheImp.setMovieUnBookMarked(movieEntity.id!!).test()

        // Assert
        testObserver.assertComplete()
    }

    @Test
    fun isCached_responseTrue() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntitiesWithNotBookmark(7)
        moviesCacheImp.saveMovies(movieEntities).test()

        // Act
        val testObserver = moviesCacheImp.isCached().test()

        // Assert
        testObserver.assertValue(true)
    }

    @Test
    fun isCached_responseFalse() {
        // Arrange
        // No arrange needed.

        // Act
        val testObserver = moviesCacheImp.isCached().test()

        // Assert
        testObserver.assertValue(false)
    }

    @Test
    fun isExpired_responseTrue() {
        // Arrange
        val currentTimeInMillis = System.currentTimeMillis()
        val expirationTime = MoviesCacheImp.EXPIRATION_TIME

        val movieEntities = CachedMovieFactory.generateListOfMovieEntitiesWithNotBookmark(7)
        moviesCacheImp.saveMovies(movieEntities).test()
        moviesCacheImp.setLastCacheTime(currentTimeInMillis.minus(expirationTime))

        // Act
        val isExpired = moviesCacheImp.isExpired()

        // Assert
        assert(isExpired)
    }

    @Test
    fun isExpired_responseFalse() {
        // Arrange
        val movieEntities = CachedMovieFactory.generateListOfMovieEntitiesWithNotBookmark(7)
        moviesCacheImp.saveMovies(movieEntities).test()
        moviesCacheImp.setLastCacheTime(System.currentTimeMillis())

        // Act
        val isExpired = moviesCacheImp.isExpired()

        // Assert
        assert(isExpired.not())
    }

    @After
    fun closeDb() {
        movieDatabase.close()
    }
}
