package com.androchef.data.repository

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import io.reactivex.Observable
import io.reactivex.Single

interface MoviesRemote {
    fun getPopularMovies() : Single<List<MovieEntity>>
    fun getMoviesCredits(movieId : Long): Single<MovieCreditEntity>
}