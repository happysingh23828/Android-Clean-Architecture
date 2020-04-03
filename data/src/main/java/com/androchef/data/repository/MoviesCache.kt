package com.androchef.data.repository

import com.androchef.data.models.MovieEntity
import com.androchef.domain.models.movies.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface MoviesCache {
    fun saveMovies(listMovies : List<MovieEntity>) : Completable
    fun getBookMarkedMovies() : Flowable<List<MovieEntity>>
    fun setMovieBookmarked(movieId: Long): Completable
    fun setMovieUnBookMarked(movieId: Long): Completable
}