package com.androchef.domain.repositories

import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies() : Single<List<Movie>>
    fun getMovieCredits(movieId : Long) : Single<MovieCredits>
    fun saveMovies(listMovies : List<Movie>) : Completable
    fun bookmarkMovie(movieId: Long) : Completable
    fun unBookmarkMovie(movieId: Long) : Completable
    fun getBookMarkedMovies() : Flowable<List<Movie>>
}