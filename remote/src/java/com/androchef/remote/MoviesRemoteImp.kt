package com.androchef.remote

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieListEntity
import com.androchef.data.repository.MoviesRemote
import com.androchef.remote.mappers.credits.MovieCreditResponseMapper
import com.androchef.remote.mappers.movies.MovieListResponseMapper
import com.androchef.remote.services.MoviesService
import io.reactivex.Single

class MoviesRemoteImp constructor(
    private val moviesService: MoviesService,
    private val moveListResponseMapper: MovieListResponseMapper,
    private val movieCreditResponseMapper: MovieCreditResponseMapper
) : MoviesRemote {

    override fun getPopularMovies(): Single<MovieListEntity> {
        return moviesService.getPopularsMovies().map { moveListResponseMapper.mapFromModel(it) }
    }

    override fun getMoviesCredits(movieId : Int): Single<MovieCreditEntity> {
        return moviesService.getMoviesCredits(movieId).map { movieCreditResponseMapper.mapFromModel(it) }
    }
}