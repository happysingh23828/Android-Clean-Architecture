package com.androchef.data.repository

import com.androchef.data.models.MovieCreditEntity
import com.androchef.data.models.MovieEntity
import io.reactivex.Single

interface MoviesRemote {
    fun getPopularMovies(): Single<List<MovieEntity>>
    fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity>
}
