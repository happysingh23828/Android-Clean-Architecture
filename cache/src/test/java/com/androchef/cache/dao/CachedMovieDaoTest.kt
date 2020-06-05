package com.androchef.cache.dao

import androidx.room.Room
import com.androchef.cache.db.MovieDatabase
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
class CachedMovieDaoTest {

    lateinit var movieDatabase: MovieDatabase

    @Before
    fun setUp() {
        movieDatabase = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.baseContext,
            MovieDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @Test
    fun addMovieToDatabase() {
        // Arrange
        val cachedMovie = CachedMovieFactory.generateCachedMovie()

        // Act
        movieDatabase.cachedMovieDao().addMovie(cachedMovie)

        // Assert
        val cachedMovies = movieDatabase.cachedMovieDao().getMovies()
        assert(cachedMovies.isNotEmpty())
    }

    @Test
    fun bookmarkMovie_completes() {
        // Arrange
        val cachedMovie = CachedMovieFactory.generateCachedMovie()
        cachedMovie.isBookMarked = false
        movieDatabase.cachedMovieDao().addMovie(cachedMovie)

        // Act
        movieDatabase.cachedMovieDao().bookmarkMovie(cachedMovie.movieId)

        // Assert
        val bookmarkedMovieList = movieDatabase.cachedMovieDao().getBookMarkedMovies()
        assert(bookmarkedMovieList.isNotEmpty())
    }

    @Test
    fun unBookmarkMovie_completes() {
        // Arrange
        val cachedMovie = CachedMovieFactory.generateCachedMovie()
        cachedMovie.isBookMarked = true
        movieDatabase.cachedMovieDao().addMovie(cachedMovie)

        // Act
        movieDatabase.cachedMovieDao().unBookmarkMovie(cachedMovie.movieId)

        // Assert
        val bookmarkedMovieList = movieDatabase.cachedMovieDao().getBookMarkedMovies()
        assert(bookmarkedMovieList.isEmpty())
    }

    @Test
    fun clearMovies_completes() {
        // Arrange
        val cachedMovies = CachedMovieFactory.generateListOfCachedMovie(8)
        repeat(cachedMovies.size) {
            movieDatabase.cachedMovieDao().addMovie(cachedMovies[it])
        }

        // Act
        movieDatabase.cachedMovieDao().clearMovies()

        // Assert
        val movies = movieDatabase.cachedMovieDao().getMovies()
        assert(movies.isEmpty())
    }

    @Test
    fun getBookMarkedMovies_returnsEmpty() {
        // Arrange
        val cachedMovie = CachedMovieFactory.generateCachedMovie()
        cachedMovie.isBookMarked = false
        movieDatabase.cachedMovieDao().addMovie(cachedMovie)

        // Act
        val bookmarkedCachedMovies = movieDatabase.cachedMovieDao().getBookMarkedMovies()

        // Assert
        assert(bookmarkedCachedMovies.isEmpty())
    }

    @Test
    fun getBookMarkedMovies_returnsData() {
        // Arrange
        val cachedMovie = CachedMovieFactory.generateCachedMovie()
        cachedMovie.isBookMarked = true
        movieDatabase.cachedMovieDao().addMovie(cachedMovie)

        // Act
        val bookmarkedCachedMovies = movieDatabase.cachedMovieDao().getBookMarkedMovies()

        // Assert
        assert(bookmarkedCachedMovies.isNotEmpty())
    }

    @Test
    fun getMovies_returnData() {
        // Arrange
        val cachedMovies = CachedMovieFactory.generateListOfCachedMovie(8)
        repeat(cachedMovies.size) {
            movieDatabase.cachedMovieDao().addMovie(cachedMovies[it])
        }

        // Act
        val movies = movieDatabase.cachedMovieDao().getMovies()

        // Assert
        assert(movies.size == cachedMovies.size)
    }

    @Test
    fun getMovies_returnEmpty() {
        // Arrange
        // No Arrangement needed

        // Act
        val movies = movieDatabase.cachedMovieDao().getMovies()

        // Assert
        assert(movies.isEmpty())
    }

    @After
    fun closeDb() {
        movieDatabase.close()
    }
}
