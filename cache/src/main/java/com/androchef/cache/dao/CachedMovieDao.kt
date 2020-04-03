package com.androchef.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androchef.cache.models.CachedMovie

@Dao
interface CachedMovieDao {

    @Query("SELECT * FROM movieTableName")
    fun getMovies() : List<CachedMovie>

    @Query("DELETE FROM movieTableName")
    fun clearMovies()

    @Query("UPDATE movieTableName SET isBookMarked = 1 WHERE id = :id")
    fun bookmarkMovie(id : Long) : Int

    @Query("UPDATE movieTableName SET isBookMarked = 0 WHERE id = :id")
    fun unBookmarkMovie(id : Long) : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(cachedMovie: CachedMovie)
}