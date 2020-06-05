package com.androchef.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androchef.cache.models.CachedMovie

@Dao
interface CachedMovieDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): List<CachedMovie>

    @Query("SELECT * FROM movies WHERE is_bookmarked = 1")
    fun getBookMarkedMovies(): List<CachedMovie>

    @Query("DELETE FROM movies")
    fun clearMovies()

    @Query("UPDATE movies SET is_bookmarked = 1 WHERE movie_id = :id")
    fun bookmarkMovie(id: Long): Int

    @Query("UPDATE movies SET is_bookmarked = 0 WHERE movie_id = :id")
    fun unBookmarkMovie(id: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(cachedMovie: CachedMovie)
}
