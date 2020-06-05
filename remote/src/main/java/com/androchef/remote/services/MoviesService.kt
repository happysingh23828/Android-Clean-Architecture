package com.androchef.remote.services

import com.androchef.remote.models.credits.MovieCreditsModel
import com.androchef.remote.models.movies.MovieListModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("movie/popular")
    fun getPopularsMovies(): Single<MovieListModel>

    @GET("movie/{movie_id}/credits")
    fun getMoviesCredits(@Path("movie_id") movieId: Int): Single<MovieCreditsModel>
}
