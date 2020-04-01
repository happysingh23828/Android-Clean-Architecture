package com.androchef.data.store

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.data.repository.MovieDataStore
import com.androchef.data.repository.MoviesCache
import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class MovieCacheDataStore constructor(
    private val moviesCache: MoviesCache
) : MovieDataStore {

    override fun getBookMarkedMovies(): Observable<List<String>> {
        return moviesCache.getBookMarkedMovies()
    }

    override fun setMovieBookmarked(movieId: Int): Completable {
        return moviesCache.setMovieBookmarked(movieId)
    }

    override fun setMovieUnBookMarked(movieId: Int): Completable {
        return moviesCache.setMovieUnBookMarked(movieId)
    }

    override fun getPopularMovies(): Single<MovieListEntity> {
        throw UnsupportedOperationException("Movies are not stored in Cache")
    }

    override fun getMoviesCredits(movieId: Int): Single<MovieCreditEntity> {
        throw UnsupportedOperationException("Movies Credits are not stored in Cache")
    }
}