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
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteDataStore @Inject constructor(
    private val moviesRemote: MoviesRemote
) : MovieDataStore {

    override fun getBookMarkedMovies(): Flowable<List<MovieEntity>> {
        throw UnsupportedOperationException("Bookmarked movies are not stored locally.")
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        throw UnsupportedOperationException("Bookmark is not available for remote")
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        throw UnsupportedOperationException("UnBookmark is not available for remote")
    }

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        return moviesRemote.getPopularMovies()
    }

    override fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity> {
        return moviesRemote.getMoviesCredits(movieId)
    }

    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("save movies action not applicable for remote")
    }

}