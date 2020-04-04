package com.androchef.cache

import com.androchef.cache.db.MovieDatabase
import com.androchef.cache.mapper.movies.MovieEntityMapper
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MoviesCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MoviesCacheImp @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val movieEntityMapper: MovieEntityMapper
) : MoviesCache {
    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        return Completable.defer {
            listMovies.map { movieEntityMapper.mapToCached(it) }.forEach {
                movieDatabase.cachedMovieDao().addMovie(it)
            }
            Completable.complete()
        }
    }

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        return Single.defer {
            Single.just(movieDatabase.cachedMovieDao().getMovies()).map {
                it.map { movieEntityMapper.mapFromCached(it) }
            }
        }
    }

    override fun getBookMarkedMovies(): Single<List<MovieEntity>> {
        return Single.defer {
            Single.just(movieDatabase.cachedMovieDao().getBookMarkedMovies()).map {
                it.map { movieEntityMapper.mapFromCached(it) }
            }
        }
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        return Completable.defer {
            movieDatabase.cachedMovieDao().bookmarkMovie(movieId)
            Completable.complete()
        }
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        return Completable.defer {
            movieDatabase.cachedMovieDao().unBookmarkMovie(movieId)
            Completable.complete()
        }
    }
}