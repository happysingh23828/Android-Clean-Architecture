package com.androchef.domain.repositories

import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies() : Single<GetMovieListUseCase.ResponseValues>
    fun getMovieCredits(movieId : Int) : Single<GetMovieCreditsUseCase.ResponseValues>
    fun bookmarkMovie(movieId: Int) : Completable
    fun unBookmarkMovie(movieId: Int) : Completable
    fun getBookMarkedMovies() : Observable<GetMovieListUseCase.ResponseValues>
}