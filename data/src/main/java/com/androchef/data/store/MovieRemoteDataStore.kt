package com.androchef.data.store

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.data.repository.MovieDataStore
import com.androchef.data.repository.MoviesRemote
import com.androchef.domain.interactor.moviecredits.GetMovieCreditsUseCase
import com.androchef.domain.interactor.movielist.GetMovieListUseCase
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class MovieRemoteDataStore constructor(
    private val moviesRemote: MoviesRemote
) : MovieDataStore {

    override fun getBookMarkedMovies(): Observable<List<String>> {
        throw UnsupportedOperationException("Bookmarked movies are not stored locally.")
    }

    override fun setMovieBookmarked(movieId: Int): Completable {
        throw UnsupportedOperationException("Bookmark is not available for remote")
    }

    override fun setMovieUnBookMarked(movieId: Int): Completable {
        throw UnsupportedOperationException("UnBookmark is not available for remote")
    }

    override fun getPopularMovies(): Single<MovieListEntity> {
        return moviesRemote.getPopularMovies()
    }

    override fun getMoviesCredits(movieId: Int): Single<MovieCreditEntity> {
        return moviesRemote.getMoviesCredits(movieId)
    }
}