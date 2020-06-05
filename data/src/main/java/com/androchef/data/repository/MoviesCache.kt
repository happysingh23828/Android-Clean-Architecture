package com.androchef.data.repository

import com.androchef.data.models.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesCache {
    fun getPopularMovies(): Single<List<MovieEntity>>
    fun saveMovies(listMovies: List<MovieEntity>): Completable
    fun getBookMarkedMovies(): Single<List<MovieEntity>>
    fun setMovieBookmarked(movieId: Long): Completable
    fun setMovieUnBookMarked(movieId: Long): Completable
    fun isCached(): Single<Boolean>
    fun setLastCacheTime(lastCache: Long)
    fun isExpired(): Boolean
}
