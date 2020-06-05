package com.androchef.remote

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import com.androchef.data.repository.MoviesRemote
import com.androchef.remote.mappers.credits.MovieCreditResponseEntityMapper
import com.androchef.remote.mappers.movies.MovieModelEntityMapper
import com.androchef.remote.services.MoviesService
import io.reactivex.Single
import javax.inject.Inject

class MoviesRemoteImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieModelEntityMapper: MovieModelEntityMapper,
    private val movieCreditResponseMapper: MovieCreditResponseEntityMapper
) : MoviesRemote {

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        return moviesService.getPopularsMovies().map { movieModel ->
            movieModel.listOfMoviesResponse.map {
                movieModelEntityMapper.mapFromModel(it)
            }
        }
    }

    override fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity> {
        return moviesService.getMoviesCredits(movieId.toInt())
            .map { movieCreditResponseMapper.mapFromModel(it) }
    }
}
