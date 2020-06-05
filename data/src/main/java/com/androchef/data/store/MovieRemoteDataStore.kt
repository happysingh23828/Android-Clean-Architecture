package com.androchef.data.store

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MovieDataStore
import com.androchef.data.repository.MoviesRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteDataStore @Inject constructor(
    private val moviesRemote: MoviesRemote
) : MovieDataStore {

    override fun getBookMarkedMovies(): Single<List<MovieEntity>> {
        throw UnsupportedOperationException("this action is not applicable for remote store.")
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        throw UnsupportedOperationException("Bookmark is not available for remote.")
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        throw UnsupportedOperationException("UnBookmark is not available for remote.")
    }

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        return moviesRemote.getPopularMovies()
    }

    override fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity> {
        return moviesRemote.getMoviesCredits(movieId)
    }

    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("save movies action not applicable for remote.")
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException("this movies action not applicable for remote.")
    }
}
