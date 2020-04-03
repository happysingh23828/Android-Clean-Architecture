package com.androchef.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androchef.cache.dao.CachedMovieDao
import com.androchef.cache.models.CachedMovie

@Database(entities = [CachedMovie::class], version = 1)
abstract class MovieDatabase  : RoomDatabase() {

    abstract fun cachedMovieDao(): CachedMovieDao

    private var INSTANCE: MovieDatabase? = null

    private val sLock = Any()

    fun getInstance(context: Context): MovieDatabase {
        if (INSTANCE == null) {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            MovieDatabase::class.java, CacheConstants.DB_NAME)
                            .build()
                }
                return INSTANCE!!
            }
        }
        return INSTANCE!!
    }

}