package com.androchef.remote.services

import com.androchef.remote.models.MovieListModel
import io.reactivex.Single
import retrofit2.http.GET

interface MoviesService {

    @GET("/3/movie/popular")
    fun getPopularsMovies() : Single<MovieListModel>

}