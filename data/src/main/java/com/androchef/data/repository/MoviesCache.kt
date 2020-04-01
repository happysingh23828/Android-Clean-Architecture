package com.androchef.data.repository

import com.androchef.data.models.MovieEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface MoviesCache {
    fun getBookMarkedMovies() : Observable<List<String>>
    fun setMovieBookmarked(movieId: Int): Completable
    fun setMovieUnBookMarked(movieId: Int): Completable
}