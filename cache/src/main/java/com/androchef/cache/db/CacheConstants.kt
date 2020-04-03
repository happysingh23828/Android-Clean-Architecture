package com.androchef.cache.db

object CacheConstants {
    const val DB_NAME = "movie.db"
    const val MOVIE_TABLE_NAME = "movieTableName"

    const val QUERY_MOVIES = "SELECT * FROM" + " " + MOVIE_TABLE_NAME
    const val DELETE_ALL_BUFFEROOS = "DELETE FROM" + " " + MOVIE_TABLE_NAME
}