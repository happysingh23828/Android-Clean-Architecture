package com.androchef.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androchef.cache.Migrations
import com.androchef.cache.dao.CachedMovieDao
import com.androchef.cache.models.CachedMovie
import javax.inject.Inject

@Database(entities = [CachedMovie::class], version = Migrations.DB_VERSION)
abstract class MovieDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedMovieDao(): CachedMovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, MovieDatabase::class.java, CacheConstants.DB_NAME
        ).build()
    }
}
