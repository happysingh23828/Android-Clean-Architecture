package com.androchef.data.repository

import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface MoviesCache {
    fun getPopularMovies() : Single<List<MovieEntity>>
    fun saveMovies(listMovies : List<MovieEntity>) : Completable
    fun getBookMarkedMovies() : Single<List<MovieEntity>>
    fun setMovieBookmarked(movieId: Long): Completable
    fun setMovieUnBookMarked(movieId: Long): Completable
    fun isCached(): Single<Boolean>
    fun setLastCacheTime(lastCache: Long)
    fun isExpired(): Boolean
}