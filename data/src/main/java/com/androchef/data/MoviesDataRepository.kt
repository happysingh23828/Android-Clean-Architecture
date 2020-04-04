package com.androchef.data

import com.androchef.data.mapper.moviecredits.MovieCreditMapper
import com.androchef.data.mapper.movielist.MovieMapper
import com.androchef.data.store.MovieDataStoreFactory
import com.androchef.domain.models.movies.Movie
import com.androchef.domain.models.movies.MovieCredits
import com.androchef.domain.repositories.MovieRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class MoviesDataRepository @Inject constructor(
    private val movieMapper: MovieMapper,
    private val movieCreditMapper: MovieCreditMapper,
    private val movieDataStoreFactory: MovieDataStoreFactory
) : MovieRepository {

    override fun getPopularMovies(): Single<List<Movie>> {
        return movieDataStoreFactory.getRemoteDataStore().getPopularMovies()
            .map { listOfMovieEnties ->
                listOfMovieEnties.map { movieMapper.mapFromEntity(it) }
            }
    }

    override fun getMovieCredits(movieId: Long): Single<MovieCredits> {
        return movieDataStoreFactory.getRemoteDataStore().getMoviesCredits(movieId).map {
            movieCreditMapper.mapFromEntity(it)
        }
    }

    override fun bookmarkMovie(movieId: Long): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieBookmarked(movieId)
    }

    override fun unBookmarkMovie(movieId: Long): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieUnBookMarked(movieId)
    }

    override fun saveMovies(listMovies: List<Movie>): Completable {
        return movieDataStoreFactory.getCacheDataStore().saveMovies(
            listMovies.map { movieMapper.mapToEntity(it) }
        )
    }

    override fun getBookMarkedMovies(): Flowable<List<Movie>> {
        return movieDataStoreFactory.getCacheDataStore().getBookMarkedMovies()
            .map { listOfMovieEntities ->
                listOfMovieEntities.map { movieMapper.mapFromEntity(it) }
            }
    }
}