package com.androchef.data.store

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MovieDataStore
import com.androchef.data.repository.MoviesCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MovieCacheDataStore @Inject constructor(
    private val moviesCache: MoviesCache
) : MovieDataStore {

    override fun getBookMarkedMovies(): Single<List<MovieEntity>> {
        return moviesCache.getBookMarkedMovies()
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        return moviesCache.setMovieBookmarked(movieId)
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        return moviesCache.setMovieUnBookMarked(movieId)
    }

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        return moviesCache.getPopularMovies()
    }

    override fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity> {
        throw UnsupportedOperationException("Movies Credits are not stored in Cache")
    }

    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        return moviesCache.saveMovies(listMovies)
            .doOnComplete {
                moviesCache.setLastCacheTime(System.currentTimeMillis())
            }
    }

    override fun isCached(): Single<Boolean> {
        return moviesCache.isCached()
    }
}
