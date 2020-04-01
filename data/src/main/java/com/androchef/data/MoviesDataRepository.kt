package com.androchef.data

import com.androchef.data.mapper.MovieCreditMapper
import com.androchef.data.mapper.MovieListMapper
import com.androchef.data.store.MovieDataStoreFactory
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.models.movies.MoviesList
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class MoviesDataRepository constructor(
    private val movieListMapper: MovieListMapper,
    private val movieCreditMapper: MovieCreditMapper,
    private val movieDataStoreFactory: MovieDataStoreFactory
) : MovieRepository {

    override fun getPopularMovies(): Single<MoviesList> {
       return movieDataStoreFactory.getRemoteDataStore().getPopularMovies().map {
           movieListMapper.mapFromEntity(it)
       }
    }

    override fun getMovieCredits(movieId: Int): Single<MovieCredits> {
        return movieDataStoreFactory.getRemoteDataStore().getMoviesCredits(movieId).map {
            movieCreditMapper.mapFromEntity(it)
        }
    }

    override fun bookmarkMovie(movieId: Int): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieBookmarked(movieId)
    }

    override fun unBookmarkMovie(movieId: Int): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieUnBookMarked(movieId)
    }

    override fun getBookMarkedMovies(): Observable<List<String>> {
        return movieDataStoreFactory.getCacheDataStore().getBookMarkedMovies()
    }
}